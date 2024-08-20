import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
          
            ProjetoDAO projetoDAO = new ProjetoDAO();
            EngenheiroDAO engenheiroDAO = new EngenheiroDAO();
            OperarioDAO operarioDAO = new OperarioDAO();
            EquipamentoDAO equipamentoDAO = new EquipamentoDAO();
            MaterialDAO materialDAO = new MaterialDAO();

           
            Projeto projeto = new Projeto();
            projeto.setNomeProjeto("Construção do Prédio A");
            projeto.setLocal("São Paulo");
            projeto.setDataInicio("2024-01-01");
            projeto.setDataTermino("2024-12-31");
            projetoDAO.inserir(projeto);

           
            Engenheiro engenheiro = new Engenheiro();
            engenheiro.setNomeEngenheiro("Carlos Silva");
            engenheiro.setEspecialidade("Civil");
            engenheiroDAO.inserir(engenheiro);

            
            Operario operario = new Operario();
            operario.setNomeOperario("José Santos");
            operario.setFuncao("Pedreiro");
            operarioDAO.inserir(operario);

            Equipamento equipamento = new Equipamento();
            equipamento.setNomeEquipamento("Escavadeira");
            equipamento.setTipo("Terra");
            equipamentoDAO.inserir(equipamento);

         
            Material material = new Material();
            material.setNomeMaterial("Cimento");
            material.setQuantidade(1000);
            materialDAO.inserir(material);

            
            projeto.setNomeProjeto("Construção do Prédio B");
            projetoDAO.atualizar(projeto);

          
            engenheiro.setEspecialidade("Estrutural");
            engenheiroDAO.atualizar(engenheiro);

            operario.setFuncao("Encanador");
            operarioDAO.atualizar(operario);

            
            equipamento.setTipo("Escavação");
            equipamentoDAO.atualizar(equipamento);

           
            material.setQuantidade(1200);
            materialDAO.atualizar(material);

            List<Projeto> projetos = projetoDAO.listarTodos();
            System.out.println("Projetos:");
            for (Projeto p : projetos) {
                System.out.println(p.getIdProjeto() + ": " + p.getNomeProjeto());
            }

           
            List<Engenheiro> engenheiros = engenheiroDAO.listarTodos();
            System.out.println("\nEngenheiros:");
            for (Engenheiro e : engenheiros) {
                System.out.println(e.getIdEngenheiro() + ": " + e.getNomeEngenheiro());
            }

            
            List<Operario> operarios = operarioDAO.listarTodos();
            System.out.println("\nOperários:");
            for (Operario o : operarios) {
                System.out.println(o.getIdOperario() + ": " + o.getNomeOperario());
            }

            List<Equipamento> equipamentos = equipamentoDAO.listarTodos();
            System.out.println("\nEquipamentos:");
            for (Equipamento eq : equipamentos) {
                System.out.println(eq.getIdEquipamento() + ": " + eq.getNomeEquipamento());
            }

          
            List<Material> materiais = materialDAO.listarTodos();
            System.out.println("\nMateriais:");
            for (Material m : materiais) {
                System.out.println(m.getIdMaterial() + ": " + m.getNomeMaterial());
            }
          
            projetoDAO.excluir(1);

            engenheiroDAO.excluir(1);

            operarioDAO.excluir(1);

            equipamentoDAO.excluir(1);

            materialDAO.excluir(1);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
