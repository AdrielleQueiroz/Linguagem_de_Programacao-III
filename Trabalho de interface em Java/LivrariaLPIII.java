import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class LivrariaLPIII extends JFrame {

  JLabel lblTitulo, lblAutor, lblAno, lblPesquisar, lblEspacoBranco;
  JLabel lblNumeroLivros;
  JTextField txtTitulo, txtAutor, txtAno, txtPesquisar;
  JButton btnSalvar, btnCancelar, btnPesquisar; // Adicionei o botão btnPesquisar

  JLabel lblListaLivros, lblListaPesquisa;
  JList jlstLivros, jlstPesquisa;
  DefaultListModel mdlListaLivros, mdlListaPesquisa;

  ArrayList<Livro> lstLivros = new ArrayList<Livro>();
  ArrayList<Livro> lstPesquisa = new ArrayList<Livro>();

  LivrariaLPIII() {
    lblTitulo = new JLabel("Titulo"); //nome do lado
    lblTitulo.setForeground(Color.WHITE); //ediçaõ de cor
    txtTitulo = new JTextField(); //caixa de texto
    lblAutor = new JLabel("Autor");
    lblAutor.setForeground(Color.WHITE);
    txtAutor = new JTextField();
    lblAno = new JLabel("Ano");
    lblAno.setForeground(Color.WHITE);
    txtAno = new JTextField();
    btnSalvar = new JButton("Salvar");
    btnSalvar.setBackground(Color.GREEN);
    btnCancelar = new JButton("Cancelar");
    btnCancelar.setBackground(Color.ORANGE);
    lblNumeroLivros = new JLabel("Total livros: 0");
    lblNumeroLivros.setForeground(Color.WHITE);
    lblEspacoBranco = new JLabel(" ");

    lblPesquisar = new JLabel("Pesquisar livro");
    lblPesquisar.setForeground(Color.WHITE);
    btnPesquisar = new JButton("Pesquisar");
    btnPesquisar.setBackground(Color.LIGHT_GRAY);

    txtPesquisar = new JTextField();
    txtPesquisar.setPreferredSize(new Dimension(250, 20));

    lblListaLivros = new JLabel("Lista de livros");
    lblListaLivros.setForeground(Color.WHITE);
    lblListaPesquisa = new JLabel("Livros encontrados");
    lblListaPesquisa.setForeground(Color.WHITE);

    mdlListaLivros = new DefaultListModel();
    mdlListaPesquisa = new DefaultListModel();

    jlstLivros = new JList(mdlListaLivros);
    jlstPesquisa = new JList(mdlListaPesquisa);

    EventoHandler handler = new EventoHandler();
    btnSalvar.addActionListener(handler);
    btnCancelar.addActionListener(handler);
    btnPesquisar.addActionListener(handler); // Adicionei o ActionListener para o botão btnPesquisar

    JPanel formularioPane = new JPanel();
    formularioPane.setBackground(Color.DARK_GRAY);
    formularioPane.setLayout(new GridLayout(7, 2));
    formularioPane.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    formularioPane.add(lblTitulo);
    formularioPane.add(txtTitulo);
    formularioPane.add(lblAutor);
    formularioPane.add(txtAutor);
    formularioPane.add(lblAno);
    formularioPane.add(txtAno);
    formularioPane.add(btnSalvar);
    formularioPane.add(btnCancelar);
    formularioPane.add(lblNumeroLivros);
    formularioPane.add(lblEspacoBranco);
    formularioPane.add(lblPesquisar);
    formularioPane.add(new JLabel(" "));

    formularioPane.add(btnPesquisar);
    formularioPane.add(txtPesquisar);

    JScrollPane listScroller = new JScrollPane(jlstLivros);
    listScroller.setPreferredSize(new Dimension(250, 150));
    listScroller.setAlignmentX(LEFT_ALIGNMENT);

    JScrollPane listScroller2 = new JScrollPane(jlstPesquisa);
    listScroller2.setPreferredSize(new Dimension(250, 150));
    listScroller2.setAlignmentX(LEFT_ALIGNMENT);

    JPanel pesquisaPane = new JPanel();
    pesquisaPane.setBackground(Color.DARK_GRAY);
    pesquisaPane.setLayout(new BoxLayout(pesquisaPane, BoxLayout.PAGE_AXIS));
    pesquisaPane.add(lblListaPesquisa);
    pesquisaPane.add(Box.createRigidArea(new Dimension(0, 5)));
    pesquisaPane.add(listScroller2);
    pesquisaPane.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

    JPanel listPane = new JPanel();
    listPane.setBackground(Color.DARK_GRAY);
    listPane.setLayout(new BoxLayout(listPane, BoxLayout.PAGE_AXIS));
    listPane.add(lblListaLivros);
    listPane.add(Box.createRigidArea(new Dimension(0, 5)));
    listPane.add(listScroller);
    listPane.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

    // **** Montando as partes maiores
    // O container da Janela (ContentPane) e
    // Os dois paineis com Formulário (superior-Norte) e Lista (Centro)
    Container contentPane = getContentPane();
    contentPane.add(formularioPane, BorderLayout.NORTH);
    contentPane.add(pesquisaPane, BorderLayout.EAST);
    contentPane.add(listPane, BorderLayout.WEST);
    contentPane.setBackground(Color.DARK_GRAY);
  }

  public void NovoLivro() {
    String strTitulo, strAutor, strAno;
    int iAno;

    try {
      strTitulo = txtTitulo.getText();
      strAutor = txtAutor.getText();
      strAno = txtAno.getText();
      if ((strTitulo.isEmpty()) || (strAutor.isEmpty()) || (strAno.isEmpty())) {
        throw new IllegalArgumentException("ERRO! Campo vazio.");
      }

      iAno = Integer.parseInt(strAno);

      Livro l = new Livro(strTitulo, strAutor, iAno);
      lstLivros.add(l);
      JOptionPane.showMessageDialog(
        rootPane,
        "Novo livro adicionado: " + l.getTitulo()
      );
    } catch (NumberFormatException ex) {
      JOptionPane.showMessageDialog(
        rootPane,
        "Ano inválido! Por favor, insira um valor numérico para o ano."
      );
    } catch (IllegalArgumentException ex) {
      JOptionPane.showMessageDialog(rootPane, ex.getMessage());
    }
    txtTitulo.setText("");
    txtAutor.setText("");
    txtAno.setText("");
    lblNumeroLivros.setText(" Total Livros : " + lstLivros.size());

    AtualizarLista();
  }

  public void PesquisarLivro() {
    String termoPesquisa = txtPesquisar.getText().toLowerCase();
    ArrayList<Livro> livrosEncontrados = new ArrayList<>();

    for (Livro livro : lstLivros) {
      if (livro.getTitulo().toLowerCase().contains(termoPesquisa)) {
        livrosEncontrados.add(livro);
      }
    }

    if (livrosEncontrados.isEmpty()) {
      JOptionPane.showMessageDialog(
        rootPane,
        "Nenhum livro encontrado com o termo: " + termoPesquisa
      );
    } else {
      JOptionPane.showMessageDialog(
        rootPane,
        "Quantidade de livros encontrados com o termo '" +
        termoPesquisa +
        "': " +
        livrosEncontrados.size()
      );
      lstPesquisa = livrosEncontrados;
      AtualizarLista2();
    }
  }

  public void AtualizarLista() {
    mdlListaLivros.clear();
    for (Livro aux : lstLivros) {
      String livroInfo =
        "Título: " +
        aux.getTitulo() +
        ", Autor: " +
        aux.getAutor() +
        ", Ano: " +
        aux.getAno();
      mdlListaLivros.addElement(livroInfo);
    }
  }

  public void AtualizarLista2() {
    mdlListaPesquisa.clear();
    for (Livro aux2 : lstPesquisa) {
      String livroInfo =
        "Título: " +
        aux2.getTitulo() +
        ", Autor: " +
        aux2.getAutor() +
        ", Ano: " +
        aux2.getAno();
      mdlListaPesquisa.addElement(livroInfo);
    }
  }

  public static void main(String[] args) {
    JFrame f = new LivrariaLPIII();
    f.setTitle("LIVRARIA LPIII");
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setBounds(300, 300, 600, 700);
    f.setVisible(true);
    f.setResizable(false);
  }

  private class EventoHandler implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent event) {
      if (event.getSource() == btnSalvar) {
        NovoLivro();
      } else if (event.getSource() == btnCancelar) {
        JOptionPane.showMessageDialog(null, "Operação cancelada.");
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(btnCancelar);
        if (frame != null) {
          frame.dispose();
        }
      } else if (event.getSource() == btnPesquisar) {
        PesquisarLivro();
      }
    }
  }

  public class Livro {

    public static Object iAno;
    private String Titulo;
    private String Autor;
    private int Ano;

    Livro(String pTitulo, String pAutor, int iAno) {
      this.Titulo = pTitulo;
      this.Autor = pAutor;
      this.Ano = iAno;
    }

    public String getTitulo() {
      return Titulo;
    }

    public void setTitulo(String Titulo) {
      this.Titulo = Titulo;
    }

    public void setAutor(String Autor) {
      this.Autor = Autor;
    }

    public String getAutor() {
      return Autor;
    }

    public int getAno() {
      return Ano;
    }

    public int setAno(int Ano) {
      return this.Ano = Ano;
    }
  }
}