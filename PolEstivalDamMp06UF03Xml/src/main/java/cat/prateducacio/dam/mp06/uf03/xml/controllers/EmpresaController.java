package cat.prateducacio.dam.mp06.uf03.xml.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cat.prateducacio.dam.mp06.uf03.xml.model.domain.Empresa;
import cat.prateducacio.dam.mp06.uf03.xml.model.service.EmpresaService;

@RestController
@RequestMapping("/empreses")
public class EmpresaController {

	@Autowired
	EmpresaService empresaService;

	@PostMapping("/add")
	public ResponseEntity<?> addEmpresa(@RequestBody Empresa empresa) {

		ResponseEntity<?> result = null;

		try {
			empresaService.add(empresa);
			result = ResponseEntity.status(HttpStatus.OK).body(empresa);
		} catch (Exception ex) {
			result = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}

		return result;
	}

	@PutMapping("/upd")
	public ResponseEntity<?> updEmpresa(@RequestBody Empresa empresa) {

		ResponseEntity<?> result = null;

		try {
			empresaService.update(empresa);
			result = ResponseEntity.status(HttpStatus.OK).body(empresa);
		} catch (Exception ex) {
			result = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}

		return result;
	}

	@DeleteMapping("/delete/{cif}")
	public ResponseEntity<?> delEmpresa(@PathVariable String cif) {

		ResponseEntity<?> result = null;

		try {
			empresaService.delete(cif);
			result = ResponseEntity.status(HttpStatus.OK).body("L'empresa ha estat eliminada");
		} catch (Exception ex) {
			result = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}

		return result;
	}

	@GetMapping("/getAll")
	public ResponseEntity<?> getAll() {

		ResponseEntity<?> result = null;

		try {
			List<Empresa> empreses = empresaService.getAll();
			result = ResponseEntity.status(HttpStatus.OK).body(empreses);
		} catch (Exception ex) {
			result = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}

		return result;

	}

	@GetMapping("/getOne/{cif}")
	public ResponseEntity<?> getByCif(@PathVariable String cif) {

		ResponseEntity<?> result = null;

		try {
			Empresa empresa = empresaService.getByCif(cif);

			if (empresa != null) {
				result = ResponseEntity.status(HttpStatus.OK).body(empresa);
			} else {
				result = ResponseEntity.status(HttpStatus.NOT_FOUND).body("L'empresa amb CIF " + cif + " no existeix.");
			}
		} catch (Exception ex) {
			result = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}

		return result;

	}

}
