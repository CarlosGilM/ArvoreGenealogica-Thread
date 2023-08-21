/* ***************************************************************
* Autor............: Carlos Gil Martins da Silva
* Matricula........: 202110261
* Inicio...........: 18/03/2023
* Ultima alteracao.: 22/03/2023
* Nome.............: Arvore Genealogica utilizando Threads
* Funcao...........: Thread do Neto, Seta um controlador comum, controla
a idade do Neto para startar os netos e altera sua imageView,
escrve no terminal quando nasce e quando morre, e segura 1sec
a cada um ano de idade
****************************************************************/

package thread;

import control.controllerGeral;

public class threadNeto02 extends Thread {
  controllerGeral cG = new controllerGeral();

  // Metodo Utilizado para Setar um Controlador em Comum em Todas Thread
  public void setControlador(controllerGeral controle) {
    this.cG = controle;
  }

  @Override
  public void run() {
    System.out.println("Segundo Neto Nasceu");
    try {
      for (int i = 0; i <= 33; i++) { // for ate idade de morte
        if (i == 7) { // if para atualizar imagem
          cG.UpdateImage("Neto02", "assets/Idade2.png"); // atualiza imagem
        }

        if (i == 22) { // if para atualizar imagem
          cG.UpdateImage("Neto02", "assets/Idade3.png"); //atualiza imagem
        }

        cG.UpdateAge("Neto02", i); // atualiza idade

        sleep(1000); // segura 1 sec
      } // Fim For

    } // Fim try
    catch (InterruptedException e) {
    }

    cG.UpdateImage("Neto02", "assets/idade5.png"); //atualiza imagem
    System.out.println("Segundo Neto Morreu aos 33 Anos de Idade");
  }
}
