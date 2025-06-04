# Fábrica de Software 2025/1

## Nome da Equipe

Kaue Gomes Cidral
Gabriel Fernandes da Costa

## Propostas de projeto

- Nome do sistema: Rede social da univille
  - Funcionalidade 1 - Cadastrar usuários
  - Funcionalidade 2 - Login e Logout de usuários
  - Funcionalidade 3 - Criar Postagens
  - Funcionalidade 4 - Curtir Postagens
  - Funcionalidade 5 - Comentar em Postagens
  - Funcionalidade 6 - Enviar Mensagens Privadas (DMs)
  - Funcionalidade 7 - Editar Perfil de Usuário
  - Funcionalidade 8 - Gerenciar Amigos/Seguidores
  - Funcionalidade 9 - Notificações de Atividades
  - Funcionalidade 10 - Configurações de Privacidade  

## Histórias de usuários

Como um usuário,eu gostaria de cadastrar uma nova conta com as minhas informações pessoais como: nome, curso, semestre/turma, telefone, email e senha
Como um usuário registrado, eu gostaria de fazer login e logout da minha conta
Como um usuário, eu gostaria de criar postagens com texto, imagens e vídeos
Como um usuário, eu gostaria de curtir postagens de outros alunos
Como um usuário, eu gostaria de comentar nas postagens de outros alunos
Como um usuário, eu gostaria de enviar mensagens privadas para outros alunos
Como um usuário, eu gostaria de editar as informações do meu perfil
Como um usuário, eu gostaria de seguir ou adicionar outros alunos como amigos
Como um usuário, eu gostaria de configurar as opções de privacidade da minha conta
Como um usuário, eu gostaria de receber notificações sobre interações nas minhas postagens e mensagens 
Como um usuário, eu gostaria de modificar minhas configurações como tema (claro e escuro), informações da conta, fazer logout, apagar conta e adicionar informações em relação ao meu perfil.
Como um usuário, eu gostaria de adicionar informações relacionadas ao perfil nas configurações como: Bio, atlética.
Como um usuáio, eu gostaria de remover postagens que eu criei.
Como um usuário, eu gostaria de remover comentários que eu fiz em publicações.

Como um usuário, eu gostaria de visualizar as pessoas que me seguem
Como um usuário, eu gostaria de visualizar as pessoas que eu sigo


## Comandos do Git

### Instalação
[Git Bash](https://git-scm.com/downloads)

### Configuração inicial

```
git config --global user.name "NOME DO USUARIO NO GITHUB"
git config --global user.email "EMAIL DA CONTA DO GITHUB"
```
### Tipos de mensagens do commit

- feat: (new feature for the user, not a new feature for build script)
- fix: (bug fix for the user, not a fix to a build script)
- docs: (changes to the documentation)
- style: (formatting, missing semi colons, etc; no production code change)
- refactor: (refactoring production code, eg. renaming a variable)
- test: (adding missing tests, refactoring tests; no production code change)
- chore: (updating grunt tasks etc; no production code change)

### Commit e Push

```
git add .
git commit -m "tipo: o que foi feito"
git push -u origin main
```

### Criar um branch a partir da branch atual
```
git checkout -b branch-seunome
```

### Revisão de Java

[Download JDK](https://adoptium.net/)

- JRE - Java Runtime Environment (java.exe)
  - Máquina virtual do Java - interpreta o Bytecode(.class) do Java para linguagem de máquina
- JDK - Java Development Kit (javac.exe)
  - Compilar o código Java em bytecode (.class)

### Criação de projeto no VSCode com Maven
1) teclar F1
2) digitar Java e escolher a opção create new java project
3) project type: MAVEN
4) Archetype: No Archetype
5) pacote digitar domínio ao contrário ex: br.univille
6) nome do projeto em minúsculo
7) usar a pasta sugerida pelo vscode

### setas não esqueça


se for uma seta aberta ou pintada com risco cheio é variável

### MVC
Model = Dados
View = Telas / codigo para desenhar tela
Controller = Controla os eventos

se for uma seta aberta ou pintada com risco cheio é variável

