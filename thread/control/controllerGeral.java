/* ***************************************************************
* Autor............: Carlos Gil Martins da Silva
* Matricula........: 202110261
* Inicio...........: 18/03/2023
* Ultima alteracao.: 22/03/2023
* Nome.............: Arvore Genealogica utilizando Threads
* Funcao...........: Controler GERAL, é o controller que gerencia
toda as threads, e toda parte do JavaFx, ele controla
todos labels, texts, images ..., inicializa as threads, seta
todos controladores em todas threads, starta as threads por 
meio dos métodos, atualiza as imagens, idades, e controla
a visualização de tudo
****************************************************************/

package control;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import thread.*;

public class controllerGeral implements Initializable {

  @FXML
  private AnchorPane AnchorPane;
  @FXML
  private ImageView imgTeste;
  @FXML
  private Button buttonIniciar;
  @FXML
  private ImageView imgTEXTO;

  @FXML
  private ImageView rotBisneto;
  @FXML
  private ImageView rotFilho01;
  @FXML
  private ImageView rotFilho02;
  @FXML
  private ImageView rotFilho03;
  @FXML
  private ImageView rotNeto01;
  @FXML
  private ImageView rotNeto02;
  @FXML
  private ImageView rotPai;

  @FXML
  private ImageView imgBisneto;
  @FXML
  private ImageView imgFilho01;
  @FXML
  private ImageView imgFilho02;
  @FXML
  private ImageView imgFilho03;
  @FXML
  private ImageView imgNeto01;
  @FXML
  private ImageView imgNeto02;
  @FXML
  private ImageView imgPai;

  @FXML
  private Text idadeBisneto;
  @FXML
  private Text idadeFilho01;
  @FXML
  private Text idadeFilho02;
  @FXML
  private Text idadeFilho03;
  @FXML
  private Text idadeNeto01;
  @FXML
  private Text idadeNeto02;
  @FXML
  private Text idadePai;

  // Instanciando Threads
  private threadPai Pai;
  private threadFilho01 Filho01;
  private threadFilho02 Filho02;
  private threadFilho03 Filho03;
  private threadNeto01 Neto01;
  private threadNeto02 Neto02;
  private threadBisneto Bisneto;

  @Override
  public void initialize(URL location, ResourceBundle resources) {

    // Inicilicalizando Todas Threads
    this.Pai = new threadPai();
    this.Filho01 = new threadFilho01();
    this.Filho02 = new threadFilho02();
    this.Filho03 = new threadFilho03();
    this.Neto01 = new threadNeto01();
    this.Neto02 = new threadNeto02();
    this.Bisneto = new threadBisneto();

    // Setando um controllador COMUM (unico) Para todas Threads
    Pai.setControlador(this);
    Filho01.setControlador(this);
    Filho02.setControlador(this);
    Filho03.setControlador(this);
    Neto01.setControlador(this);
    Neto02.setControlador(this);
    Bisneto.setControlador(this);
  }

  @FXML
  void clickButtonIniciar(MouseEvent event) { // Evento de Clicar no Botão Inicial
    imgTEXTO.setVisible(false);
    buttonIniciar.setDisable(true);
    buttonIniciar.setVisible(false);
    HabilitarVisualizacao("Pai");
    Pai.start();
  }

  // Metodo para Startar as Threads
  public void StartThread(String src) {
    switch (src) {
      case "Filho01":
        Filho01.start(); // Starta Thread
        HabilitarVisualizacao("Filho01"); // Chama o habilitar Visualização
        break;
      case "Filho02":
        Filho02.start(); // Starta Thread
        HabilitarVisualizacao("Filho02"); // Chama o habilitar Visualização
        break;
      case "Filho03":
        Filho03.start(); // Starta Thread
        HabilitarVisualizacao("Filho03"); // Chama o habilitar Visualização
        break;
      case "Neto01":
        Neto01.start(); // Starta Thread
        HabilitarVisualizacao("Neto01"); // Chama o habilitar Visualização
        break;
      case "Neto02":
        Neto02.start(); // Starta Thread
        HabilitarVisualizacao("Neto02"); // Chama o habilitar Visualização
        break;
      case "Bisneto":
        Bisneto.start(); // Starta Thread
        HabilitarVisualizacao("Bisneto"); // Chama o habilitar Visualização
        break;
    }
  }

  // Metodo para Alterar as Imagens
  public void UpdateImage(String src, String img) {
    switch (src) {
      case "Pai":
        imgPai.setImage(new Image(img)); // Seta imagem
        break;
      case "Filho01":
        imgFilho01.setImage(new Image(img)); // Seta imagem
        break;
      case "Filho02":
        imgFilho02.setImage(new Image(img)); // Seta imagem
        break;
      case "Filho03":
        imgFilho03.setImage(new Image(img)); // Seta imagem
        break;
      case "Neto01":
        imgNeto01.setImage(new Image(img)); // Seta imagem
        break;
      case "Neto02":
        imgNeto02.setImage(new Image(img)); // Seta imagem
        break;
      case "Bisneto":
        imgBisneto.setImage(new Image(img)); // Seta imagem
        break;
    }
  }

  // Metodos para Alterar as Idades
  // e o Texto com sua idade de Morte
  public void UpdateAge(String src, int age) {
    Platform.runLater(() -> {
      switch (src) {
        // Case PAI
        case "Pai":
          idadePai.setText(String.valueOf("IDADE: " + age)); // Atualiza idade
          break;
        // Case Filho01
        case "Filho01":
          idadeFilho01.setText(String.valueOf("IDADE: " + age)); // Atualiza idade
          break;
        // Case Filho02
        case "Filho02":
          idadeFilho02.setText(String.valueOf("IDADE: " + age)); // Atualiza idade
          break;
        // Case Filho03
        case "Filho03":
          idadeFilho03.setText(String.valueOf("IDADE: " + age));// Atualiza idade
          break; 
        // Case Neto01
        case "Neto01":
          idadeNeto01.setText(String.valueOf("IDADE: " + age)); // Atualiza idade
          break;
        // Case Neto02
        case "Neto02":
          idadeNeto02.setText(String.valueOf("IDADE: " + age)); // Atualiza idade
          break;
        // Case Bisneto
        case "Bisneto":
          idadeBisneto.setText(String.valueOf("IDADE: " + age)); // Atualiza idade
          break;
      }
    });
  }

  // Método para controlar a visualização dos itens na árvore
  // Seta O Rótulo, imagem e texto
  public void HabilitarVisualizacao(String src) {
    switch (src) {
      case "Pai":
        rotPai.setVisible(true); // Seta visualizacao do Rotulo
        imgPai.setVisible(true); // Seta visualizacao da imagem
        idadePai.setVisible(true); // Seta visualizacao do texto
        break;
      case "Filho01":
        rotFilho01.setVisible(true); // Seta visualizacao do Rotulo
        imgFilho01.setVisible(true); // Seta visualizacao da imagem
        idadeFilho01.setVisible(true); // Seta visualizacao do texto
        break;
      case "Filho02":
        rotFilho02.setVisible(true); // Seta visualizacao do Rotulo
        imgFilho02.setVisible(true); // Seta visualizacao da imagem
        idadeFilho02.setVisible(true); // Seta visualizacao do texto
        break;
      case "Filho03":
        rotFilho03.setVisible(true); // Seta visualizacao do Rotulo
        imgFilho03.setVisible(true); // Seta visualizacao da imagem
        idadeFilho03.setVisible(true); // Seta visualizacao do texto
        break;
      case "Neto01":
        rotNeto01.setVisible(true); // Seta visualizacao do Rotulo
        imgNeto01.setVisible(true); // Seta visualizacao da imagem
        idadeNeto01.setVisible(true); // Seta visualizacao do texto
        break;
      case "Neto02":
        rotNeto02.setVisible(true); // Seta visualizacao do Rotulo
        imgNeto02.setVisible(true); // Seta visualizacao da imagem
        idadeNeto02.setVisible(true); // Seta visualizacao do texto
        break;
      case "Bisneto":
        rotBisneto.setVisible(true); // Seta visualizacao do Rotulo
        imgBisneto.setVisible(true); // Seta visualizacao da imagem
        idadeBisneto.setVisible(true); // Seta visualizacao do texto
        break;
    }
  }

}
