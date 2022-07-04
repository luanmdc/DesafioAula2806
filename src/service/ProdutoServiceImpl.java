package service;

import dto.ProdutoDTO;
import model.Produto;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoServiceImpl implements ProdutoService {
    //1- Criar um método que valide se o preço é maior que 0. Se for, cria o produto.

    public ProdutoDTO verificaMaiorQue0(ProdutoDTO request) throws IOException {
        if (request.getPreco() > 0) {
            Produto produto = instanciaProduto(request);
            ProdutoDTO response = instanciaResponse(produto);
            bufferedWriter();
        } else
            System.out.println("o produto nao foi cadastrado");
     return request;
 }

    //2- Criar um método que só crie produtos com preço acima de 100. Caso contrário, uma mensagem deverá ser informada.
    private void checkBiggerThan100(ProdutoDTO request) throws IOException {
        if (request.getPreco() > 100) {
            Produto produto = instanciaProduto(request);
            ProdutoDTO response = instanciaResponse(produto);
            bufferedWriter();

        }else
            System.out.println("The product wasn´t recorded, because the price is lower than $100,00.");

    }

    //3- Criar um método que crie produtos somente com a descrição contendo mais de 300 caracteres.
    // Descrições menores não deverão ser criadas e uma mensagem deve ser informada
   // @Override
    public ProdutoDTO checkCharacters(ProdutoDTO request) throws IOException {

        if (request.getDescricao().length() > 300) {

            Produto produto = instanciaProduto(request);
            ProdutoDTO response = instanciaResponse(produto);
            bufferedWriter();

        }else
            System.out.println("The product wasn´t recorded, because there aren´t more than 300 characters");

       return request;
    }




    @Override
    public ProdutoDTO criaProduto(ProdutoDTO request) throws IOException {


        Produto produto = instanciaProduto(request);

        ProdutoDTO response = instanciaResponse(produto);


        bufferedWriter();


        return response;
    }

    @Override
    public List<ProdutoDTO> bulkCreate(List<ProdutoDTO> requests) throws IOException {

//1

        List<ProdutoDTO> produtoDTOS = new ArrayList<>();
        List<Produto> produtos = new ArrayList<>();
        List<ProdutoDTO> responses = new ArrayList<>();

//2
        for (ProdutoDTO request : requests) {
            Produto produto = instanciaProduto(request);
//3
            produtos.add(produto);

        }
        BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Luan Carvalho\\Documents\\GitHub\\tempfile2.txt"));

//4
        for (Produto produto : produtos) {

            ProdutoDTO response = instanciaResponse(produto);
            responses.add(response);


            writer.write(produto.toString());
            writer.newLine();
        }
        writer.close();

        exibeConfirmacao();

        return produtoDTOS;
    }

    private void exibeConfirmacao() {
        System.out.println("o produto foi criado com sucesso");
    }

    private Produto instanciaProduto(ProdutoDTO request) {

        Produto produto = new Produto();
        produto.setMarca(request.getMarca());
        produto.setNome(request.getNome());
        produto.setDescricao(request.getDescricao());
        produto.setPreco(request.getPreco());
        return produto;

    }


    private ProdutoDTO instanciaResponse(Produto produto) {

        ProdutoDTO response = new ProdutoDTO();
        response.setMarca(produto.getMarca());
        response.setNome(produto.getNome());
        response.setDescricao(produto.getDescricao());
        response.setPreco(produto.getPreco());

        return response;
    }

    private void bufferedWriter() throws IOException {
        bufferedWriter();
        BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Luan Carvalho\\Documents\\GitHub\\tempfile.txt"));
        writer.write(toString());
        writer.newLine();
        writer.close();

    }


}


