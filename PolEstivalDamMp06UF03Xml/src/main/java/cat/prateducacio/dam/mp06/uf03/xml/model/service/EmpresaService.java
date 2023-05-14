package cat.prateducacio.dam.mp06.uf03.xml.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.prateducacio.dam.mp06.uf03.xml.model.domain.Empresa;
import cat.prateducacio.dam.mp06.uf03.xml.model.repository.EmpresaRepository;

@Service
public class EmpresaService {
	@Autowired
	EmpresaRepository empresaRepository;

	public void add(Empresa empresa) {
		empresaRepository.add(empresa);
	}

	public void update(Empresa empresa) {
		empresaRepository.update(empresa);
	}

	public void delete(String cif) {
		empresaRepository.delete(cif);
	}

	public List<Empresa> getAll() {
		return empresaRepository.getAll();
	}

	public Empresa getByCif(String cif) {
		return empresaRepository.getByCif(cif);
	}

}