package br.uema.clinica_odontologica_api.repository;

import br.uema.clinica_odontologica_api.entity.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Integer> {
    @Query(value = """
        SELECT p.nome AS paciente,
               d.nome AS dentista,
               e.nome_especialidade AS especialidade,
               c.data_consulta,
               c.hora_consulta,
               c.status_consulta
        FROM consulta c
        JOIN paciente p ON c.id_paciente = p.id_paciente
        JOIN dentista d ON c.id_dentista = d.id_dentista
        JOIN especialidade e ON d.id_especialidade = e.id_especialidade
        ORDER BY c.data_consulta DESC
    """, nativeQuery = true)
    List<Object[]> historicoConsultas();

    @Query(value = """
    SELECT d.nome,
           SUM(p.valor) AS total_arrecadado
    FROM PAGAMENTO p
    JOIN CONSULTA c ON p.id_consulta = c.id_consulta
    JOIN DENTISTA d ON c.id_dentista = d.id_dentista
    GROUP BY d.nome
    """, nativeQuery = true)
    List<Object[]> arrecadacaoPorDentista();
}