package resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Categoria;
import repository.CategoriaRepository;

/* no rest trabalhamos em cima de recursos
 * é a classe que vai expor tudo que esteja relacionado
 * com categoria.
 * @RestController - controlador,uma classe que recebe requisições o retorno será
 * convertido para json.não é necessário adicionar anotações extras nos nossos métodos.
 * @RequestMapping - mapeamento da requisição, quando chegar uma requisição ele identifica 
 * pela url e direciona.
 * @Autowired - quero que você encontre uma implementação de categoriaRepository e injete
 * nesse variavel.
 */
@RestController
@RequestMapping("/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaRepository repository;
	
	@GetMapping
	public List<Categoria> listar(){
		return repository.findAll();
	}
	
	/*
	@GetMapping
	public ResponseEntity<?> listar(){
		List<Categoria> categorias = repository.findAll();
		return categorias.isEmpty()?ResponseEntity.ok(categorias): ResponseEntity.notFound().build();
	}
	*/

}
