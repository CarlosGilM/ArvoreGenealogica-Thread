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

public class threadFilho03 extends Thread {
  controllerGeral cG = new controllerGeral();


 // Metodo Utilizado para Setar um Controlador em Comum em Todas Threads
  public void setControlador(controllerGeral controle) {
    this.cG = controle;
  }

  @Override
  public void run() { // inicio run

    System.out.println("Terceiro Filho Nasceu");
    try {
      for (int i = 0; i <= 55; i++) { // for ate idade de morte

        if (i == 7) { // if para atualizar imagem
          cG.UpdateImage("Filho03", "assets/Idade2.png"); //atualiza imagem
        }

        if (i == 22) { // if para atualizar imagem
          cG.UpdateImage("Filho03", "assets/Idade3.png"); //atualiza imagem
        }

        if (i == 45) { // if para atualizar imagem
          cG.UpdateImage("Filho03", "assets/Idade4.png"); //atualiza imagem
        }

        cG.UpdateAge("Filho03", i); //atualiza idade
        sleep(1000); // segura 1 sec
      } // Fim For

    } // Fim Try
    catch (InterruptedException e) {
    }
    cG.UpdateImage("Filho03", "assets/idade5.png"); //atualiza imagem
    System.out.println("Terceiro Filho Morreu aos 55 Anos de Idade");

  }

}
