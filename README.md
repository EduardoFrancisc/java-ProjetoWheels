# Projeto Wheels

O **Projeto Wheels** é uma aplicação desenvolvida em Java que simula a gestão de um sistema de locação de bicicletas. Este projeto foi criado com o objetivo de fornecer uma solução prática para o gerenciamento de frota, clientes e aluguéis, permitindo realizar operações como cadastro clientes e controle de reservas.

## Descrição do Projeto

O sistema permite realizar operações essenciais para uma locadora de bicicletas, incluindo:

- **Cadastro de Clientes**: Gerenciar clientes, armazenando informações como nome, documento de identidade e informações de contato.
- **Reserva de bicicletas**: Gerenciar o aluguel dos bicicletas, incluindo a criação de reservas, a checagem de disponibilidade e o controle de datas de retirada e devolução.

### Componentes Principais

1. **Gestão de Clientes**: Registro e consulta de clientes, facilitando a criação de novas reservas.

2. **Controle de Reservas**: Criação e gerenciamento de reservas de bicicletas para clientes, verificando a disponibilidade e gerenciando o status da locação.

### Arquitetura do Sistema

O **Projeto Wheels** utiliza uma arquitetura modular, dividindo o código em camadas distintas para melhorar a organização e facilitar a manutenção do código.

- **Camada de Dados (DAO)**: Responsável pelo acesso ao banco de dados e pela persistência de informações dos bicicletas, clientes e reservas.
- **Camada de Negócio (Serviços)**: Contém a lógica principal do sistema, como o cálculo de disponibilidade de bicicletas e o gerenciamento de reservas.
- **Camada de Apresentação (UI)**: Interface do usuário, por meio da qual os usuários podem interagir com o sistema e realizar as operações.

### Tecnologias Utilizadas

- **Java**: Linguagem principal utilizada no desenvolvimento da aplicação.
- **Swing**: Utilizado para a criação da interface gráfica do sistema.

## Interface Gráfica.
![image](https://github.com/EduardoFrancisc/java-ProjetoWheels/assets/137932110/6a4504fe-e7c8-4adf-aa60-a2a589cdf637)
    
## Persistência dos dados em Arquivo CSV e Impressão do Recibo em PDF.
![image](https://github.com/EduardoFrancisc/java-ProjetoWheels/assets/137932110/46fb07c6-c45e-40b8-ba0d-1090231f0704)
![image](https://github.com/EduardoFrancisc/java-ProjetoWheels/assets/137932110/8cc7caae-bb88-429f-a341-d703f5a4d5ce)

