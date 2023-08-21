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

public class threadNeto01 extends Thread {
  controllerGeral cG = new controllerGeral();

   // Metodo Utilizado para Setar um Controlador em Comum em Todas Threads
  public void setControlador(controllerGeral controle) {
    this.cG = controle;
  }

  @Override
  public void run() {
    System.out.println("Primeiro Neto Nasceu");
    try {
      for (int i = 0; i <= 35; i++) { // for até a morte
        if (i == 7) { // if para atualizar imagem 
          cG.UpdateImage("Neto01", "assets/Idade2.png"); //atualiza imagem
        }

        if (i == 22) { // if para atualizar imagem
          cG.UpdateImage("Neto01", "assets/Idade3.png"); // atualiza imagem
        }

        if (i == 30) { // if para startar bisneto
          cG.StartThread("Bisneto"); // starta bisneto
        }
        cG.UpdateAge("Neto01", i); // atualiza idade
        sleep(1000); //segura um sec
      } // Fim For

    } // Fim Try
    catch (InterruptedException e) {
    }
    cG.UpdateImage("Neto01", "assets/idade5.png"); // atualiza imagem
    System.out.println("Primeiro Neto Morreu aos 35 Anos de Idade");
  }
}
