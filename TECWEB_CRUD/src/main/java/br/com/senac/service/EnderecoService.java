package br.com.senac.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.entity.Aluno;
import br.com.senac.entity.Endereco;
import br.com.senac.repository.EnderecoRepository;

@Service
public class EnderecoService {
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	
	
	public Endereco salvar(Endereco endereco){
        return enderecoRepository.save(endereco);
    }
	
	public Endereco buscarEnderecoId(Integer id) throws ObjectNotFoundException{
        Optional<Endereco> Endereco = enderecoRepository.findById(id);

        return Endereco.orElseThrow( () -> new ObjectNotFoundException(1L, "Endereço não encontrado"));
    }

    public List<Endereco> getAllEndereco(){
		return enderecoRepository.findAll();
	}

    public Endereco salvarAlteracao(Endereco enderecoAlterado){
        Endereco endereco = this.buscarEnderecoId(enderecoAlterado.getId());
        endereco.setRua(enderecoAlterado.getRua());
        endereco.setNumero(enderecoAlterado.getNumero());
        endereco.setComplemento(enderecoAlterado.getComplemento());
        endereco.setBairro(enderecoAlterado.getBairro());
        endereco.setCep(enderecoAlterado.getCep());
        return salvar(endereco);
    }
	
    public void deletarEnderecoId(Integer id){
    	enderecoRepository.deleteById(id);
    }
    
    
    public List<Endereco> buscar (Aluno aluno){
        return enderecoRepository.findByAluno(aluno);
    }
}
