<h1 align="center">Projeto Api TMDB</h1>

<p align="center">
  <a href="https://opensource.org/licenses/Apache-2.0"><img alt="License" src="https://img.shields.io/badge/License-Apache%202.0-blue.svg"/></a>
  <a href="https://android-arsenal.com/api?level=26"><img src="https://img.shields.io/badge/API-26%2B-brightgreen.svg?style=flat" border="0" alt="API"></a>
  <br>
  <a href="https://wa.me/+5547984252271"><img alt="WhatsApp" src="https://img.shields.io/badge/WhatsApp-25D366?style=for-the-badge&logo=whatsapp&logoColor=white"/></a>
  <a href="mailto:rubensfb1985@gmail.com"><img alt="Gmail" src="https://img.shields.io/badge/Gmail-D14836?style=for-the-badge&logo=gmail&logoColor=white"/></a>
</p>

<p align="center">  

⭐ Projeto para demonstrar meu conhecimento técnico no desenvolvimento Android nativo com Kotlin. Utilizando a API The Movie DB.

</p>

</br>

<p float="left" align="center">
   <img alt="screenshot" width="30%" src="screenshots/Screenshot_01.png"/>
   <img alt="screenshot" width="30%" src="screenshots/Screenshot_2.png"/>
   <img alt="screenshot" width="30%" src="screenshots/Screenshot_3.png"/>
   <img alt="screenshot" width="30%" src="screenshots/Screenshot_4.png"/>
      
   </p>

## Download

Faça o download da <a href="apk/app-debug.apk?raw=true">APK diretamente</a>. Você pode ver <a href="https://www.google.com/search?q=como+instalar+um+apk+no+android">aqui</a> como instalar uma APK no seu aparelho android.

## Tecnologias usadas e bibliotecas de código aberto

- Minimum SDK level 26
- [Linguagem Kotlin](https://kotlinlang.org/)

- Jetpack
  - Lifecycle: Observe os ciclos de vida do Android e manipule os estados da interface do usuário após as alterações do ciclo de vida.
  - ViewModel: Gerencia o detentor de dados relacionados à interface do usuário e o ciclo de vida. Permite que os dados sobrevivam a alterações de configuração, como rotações de tela.
  - ViewBinding: Liga os componentes do XML no Kotlin através de uma classe que garante segurança de tipo e outras vantagens.
  - Custom Views: View customizadas feitas do zero usando XML.
  - Navigation: Gerencie links diretos e navegue entre telas.
  - Recyclerview: Mostre grandes conjuntos de dados na IU enquanto minimiza o uso de memória.

- Arquitetura
  - MVVM (Model - View - ViewModel) com Clean Architecture
  - Comunicação da ViewModel com a View através de LiveData
  - Repositories para abstração da comunidação com a camada de dados.
  
- Bibliotecas
  - [Dagger Hilt](https://developer.android.com/training/dependency-injection/hilt-android?hl=pt-br) : Para fazer injeção de dependências que reduz o código boilerplate.
  - [Retrofit2 & OkHttp3](https://github.com/square/retrofit): Para realizar requisições seguindo o padrão HTTP.
  - [Picasso](https://github.com/square/picasso): Para carregamento de imagens e cacheamento das mesmas.
 
## Arquitetura
**Projeto Firebase** utiliza a arquitetura MVVM com Clean Architecture e o padrão de Repositories, que segue as [recomendações oficiais do Google](https://developer.android.com/topic/architecture).
</br></br>
 <img alt="screenshot" width="30%" src="screenshots/MVVM-with-Clean-Architecture.png"/>
<br>

## Features

### Feature 1
<img src="screenshots/features_1.gif" width="25%"/>

Listagem dos filmes por categorias.

### Feature 2
<img src="screenshots/features_2.gif" width="25%"/>

Detalhes dos filmes.

### Feature 2
<img src="screenshots/features_3.gif" width="25%"/>

Opção de busca pelo nome do filme.

# Licença

```xml

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

```
Google Play e o logótipo do Google Play são marcas comerciais da Google LLC.
