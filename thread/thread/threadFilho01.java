/* ***************************************************************
* Autor............: Carlos Gil Martins da Silva
* Matricula........: 202110261
* Inicio...........: 18/03/2023
* Ultima alteracao.: 22/03/2023
* Nome.............: Arvore Genealogica utilizando Threads
* Funcao...........: Thread do Filho, Seta um controlador comum, controla
a idade do Filho para startar os netos e altera sua imageView,
escrve no terminal quando nasce e quando morre, e segura 1sec
a cada um ano de idade
****************************************************************/

package thread;

import control.controllerGeral;

public class threadFilho01 extends Thread {
  controllerGeral cG = new controllerGeral(); //Instancia do Controller

    // Metodo Utilizado para Setar um Controlador em Comum em Todas Threads
  public void setControlador(controllerGeral controle) {
    this.cG = controle;
  }

  @Override
  public void run() { // inicio Run
    System.out.println("Primeiro Filho Nasceu");
    try {
      for (int i = 0; i <= 61; i++) { // For até a idade de morte

        if (i == 7) { // if para atualizar imagem
          cG.UpdateImage("Filho01", "assets/Idade2.png"); // Atualiza imagem filho
        }

        if (i == 22) { // if para atualizar imagem
          cG.UpdateImage("Filho01", "assets/Idade3.png"); // Atualiza imagem filho
        }

        if (i == 45) { // if para atualizar imagem
          cG.UpdateImage("Filho01", "assets/Idade4.png"); // Atualiza imagem filho
        }

        if (i == 16) { // if para 
          cG.StartThread("Neto01"); // Starta o Thread
        }

        cG.UpdateAge("Filho01", i); // Atualiza idade
        sleep(1000); //Segura 01 segundo
      } // Fim For

    } // Fim try
    catch (InterruptedException e) {
    }
    cG.UpdateImage("Filho01", "assets/idade5.png"); // Atualiza imagem
    System.out.println("Primeiro Filho Morreu aos 61 Anos de Idade");
  } // Fim run

}
