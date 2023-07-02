package br.com.projet.onibus.empresa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IEmpresaRepository extends JpaRepository<Empresa, Long> {
    List<Empresa> findAllByAtivoTrue();
}
