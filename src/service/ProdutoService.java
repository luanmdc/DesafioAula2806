package service;

import dto.ProdutoDTO;
import model.Produto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface ProdutoService {

    ProdutoDTO criaProduto(ProdutoDTO request) throws IOException;

    List<ProdutoDTO> bulkCreate(List<ProdutoDTO> requests) throws IOException;

    // 3 ProdutoDTO checkCharacters(ProdutoDTO request) throws IOException;

    // 1 ProdutoDTO verificaMaiorQue0(ProdutoDTO request) throws IOException;
}

