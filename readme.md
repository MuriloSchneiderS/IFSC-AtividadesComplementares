### Trabalho Projeto de Sistemas IFSC ADS3
## Atividades Complementares
# Murilo Schneider Santos
trabalho https://docs.google.com/document/d/1kSav-UXmZEFopwscycWXxm8R7VBv0SkPJmUgvKisR3E/edit?tab=t.0
Regulamento https://sigaa.ifsc.edu.br/sigaa/verProducao?idProducao=240574&key=ff1ab2ab0e6c0ffac0a533945d11f024
BD https://docs.google.com/document/d/1YguIAsfBEvwqpFazURj043ke0z1BD6aHcQE3zGLYGx8/edit?tab=t.0

## Instruções de Uso do Sistema
1. Configure o banco de dados PostgreSQL conforme o script `Dao/AtividadesComplementares.sql`.
2. Atualize as configurações de conexão com o banco de dados no projeto, se necessário.
3. Compile e execute o sistema conforme as instruções do projeto.
4. Acesse as funcionalidades pelo menu principal da aplicação.
5. Primeiro, digite o ID do aluno (neste exemplo utilizado no lugar da matrícula).
    1. Caso o ID não for encontrado no banco de dados, digite 'S' para criar um novo aluno com aquele id ou 'N' para cancelar a operação e finalizar o sistema.
    2. Ao criar um aluno, digite apenas o nome do aluno (id/matrícula gerado automaticamente).
6. Digite o número correspondente a Modalidade da Atividade Complementar desejada.
7. Digite o número correspondente a Atividade Complementar realizada.
8. Digite a quantidade de horas inteiras declaradas para a Atividade Complementar realizada.
    Obs: caso o valor ultrapasse o limite, as horas validadas serão correspondentes ao máximo de horas permitido pela atividade.
9. Digite 0 para voltar ao menu de modalidades ou o número correspondente a próxima Atividade Complementar realizada nesta modalidade.
10. Digite 0 para Finalizar o sistema e emitir o parecer do requerimento criado para o aluno informado anteriormente.