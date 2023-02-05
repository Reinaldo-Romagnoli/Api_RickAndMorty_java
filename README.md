# **RICK AND MORTY API**

## Rodar com Docker

### Clone este repositório na sua máquina
```bash
git clone 
```

### Faça um build da imagem Docker
```bash
docker build -t rick-and-morty-api .
```

### Rode a imagem 
```bash
docker run -p 8080:8080 rick-and-morty-api
```

## Rotas da aplicação

As rotas da aplicação estão documentadas no [Postman](https://www.postman.com/joint-operations-observer-60140880/workspace/ifpr/collection/23937764-c777b2f8-8a7e-43c1-ba47-be060039d91d?action=share&creator=23937764). Lembre-se de selecionar no canto superior direito as variáveis de ambiente `DEV`.