package br.univille.projfabsoftredesocial.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.projfabsoftredesocial.entity.Postagem;
import br.univille.projfabsoftredesocial.repository.PostagemRepository;
import br.univille.projfabsoftredesocial.service.PostagemService;

@Service
public class PostagemServiceImpl implements PostagemService {

    @Autowired
    private PostagemRepository repository;

        @Override
    public Postagem save(Postagem postagem) {
        saveFoto(postagem);
        repository.save(postagem);
        return postagem;
    }

      @Override
    public List<Postagem> getAll() {
        var listaPostagens = repository.findAll();
        listaPostagens.stream()
            .filter(postagem -> postagem.getArquivoFoto() != null && !postagem.getArquivoFoto().isEmpty())
            .forEach(this::carregaFoto);
        return repository.findAll();
    }

    @Override
    public Postagem getById(Long id) {
        var retorno = repository.findById(id);
        if(retorno.isPresent()){
            var umPostagem = retorno.get();
            carregaFoto(umPostagem);
            return umPostagem;
        }
        return null;
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }

        @Value("${fabrica2025.tempfolder}")
    private String tempFolder;
    private Path root = null;

    private void saveFoto(Postagem postagem){

        if(postagem.getFoto() == null || postagem.getFoto().equals("")){
            return;
        }

        if (!postagem.getMimeType().startsWith("image/")) {
            return;
        }

        byte[] imageBytes = Base64.getDecoder().decode(postagem.getFoto());
        InputStream imageStream = new ByteArrayInputStream(imageBytes);

        File dir = new File(tempFolder);
        if (! dir.exists()){
            dir.mkdir();
        }

        root = Paths.get(tempFolder);
        UUID uuid = UUID.randomUUID();
        String novoNome = String.format("%s.%s", uuid.toString(), postagem.getArquivoFoto().split("\\.")[1]);
        Path nomeArquivo = this.root.resolve(novoNome);
        try {
            Files.copy(imageStream, nomeArquivo);
        } catch (Exception e) {
            throw new RuntimeException("Não foi possível salvar o arquivo. Error: " + e.getMessage());
        }
        postagem.setArquivoFoto(nomeArquivo.toAbsolutePath().toString());
    }

    private Postagem carregaFoto(Postagem postagem){
        if(postagem.getArquivoFoto() == null || postagem.getArquivoFoto().equals("")){
            return postagem;
        }

        File file = new File(postagem.getArquivoFoto());
        if(!file.exists()){
            return postagem;
        }

        try {
            byte[] imageBytes = Files.readAllBytes(file.toPath());
            String base64Image = Base64.getEncoder().encodeToString(imageBytes);
            postagem.setFoto(base64Image);
        } catch (Exception e) {
            throw new RuntimeException("Não foi possível carregar a foto. Error: " + e.getMessage());
        }
        
        return postagem;
    }
}