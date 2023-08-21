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

public class threadFilho02 extends Thread {
  controllerGeral cG = new controllerGeral();

  // Metodo Utilizado para Setar um Controlador em Comum em Todas Thread
  public void setControlador(controllerGeral controle) {
    this.cG = controle;
  }

  @Override
  public void run() { // Inicio Run
    System.out.println("Segundo Filho Nasceu");
    try {
      for (int i = 0; i <= 55; i++) { // For até a idade de morte
        if (i == 7) { // if para atualizar imagem
          cG.UpdateImage("Filho02", "assets/Idade2.png"); // atualiza imagem
        }

        if (i == 22) { // if para atualizar imagem
          cG.UpdateImage("Filho02", "assets/Idade3.png"); // atualiza imagem
        }

        if (i == 45) { // if para atualizar imagem
          cG.UpdateImage("Filho02", "assets/Idade4.png"); // atualiza imagem
        }

        if (i == 20) { // if para startar Filho
          cG.StartThread("Neto02"); // start Neto
        }
        cG.UpdateAge("Filho02", i); // atualiza idade
        sleep(1000); // segura idade
      } // Fim For

    } // Fim try
    catch (InterruptedException e) {
    }
    cG.UpdateImage("Filho02", "assets/idade5.png"); // atualiza imagem
    System.out.println("Segundo Filho Morreu aos 55 Anos de Idade");

  }

}
