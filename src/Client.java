
import dto.ProdutoDTO;
import service.ProdutoService;
import service.ProdutoServiceImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) throws IOException {
        ProdutoDTO produtoDTO = new ProdutoDTO();
        produtoDTO.setPreco(10.5);
        produtoDTO.setNome("sabao");
        produtoDTO.setMarca("omo");
        produtoDTO.setDescricao("detergente em po");


        ProdutoService produtoService = new ProdutoServiceImpl();
        //       produtoService.criaProduto(produtoDTO);


        List<ProdutoDTO>produtoDTOs = new ArrayList<>();

        ProdutoDTO request = new ProdutoDTO();
        request.setNome("picanha");
        request.setMarca("friboi");
        request.setPreco(100.50);
        request.setDescricao("nobre");
        produtoDTOs.add(request);


        request = new ProdutoDTO();
        request.setNome("Fraldinha");
        request.setMarca("friboi");
        request.setPreco(90.40);
        request.setDescricao("maturada");
        produtoDTOs.add(request);

        request = new ProdutoDTO();
        request.setNome("panceta");
        request.setMarca("Ioti");
        request.setPreco(25.50);
        request.setDescricao("fit");
        produtoDTOs.add(request);

        request = new ProdutoDTO();
        request.setNome("coraçãozinho");
        request.setMarca("sadia");
        request.setPreco(25.50);
        request.setDescricao("fit");
        produtoDTOs.add(request);

        produtoService.bulkCreate(produtoDTOs);





    }

}


