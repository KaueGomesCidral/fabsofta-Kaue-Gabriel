# Fábrica de Software 2025/1

Kaue Gomes Cidral
Gabriel Fernandes da Costa

## Propostas de projeto

- Nome do sistema Ex:(Sistema para Mecânica)
  - Funcionalidade 1 Cadastrar dados do Cliente
  - Funcionalidade 2 Cadastrar veículos
  - Funcionalidade 3


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
