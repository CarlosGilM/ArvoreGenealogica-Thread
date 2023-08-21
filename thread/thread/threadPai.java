/* ***************************************************************
* Autor............: Carlos Gil Martins da Silva
* Matricula........: 202110261
* Inicio...........: 18/03/2023
* Ultima alteracao.: 22/03/2023
* Nome.............: Arvore Genealogica utilizando Threads
* Funcao...........: Thread do Pai, Seta um controlador comum, controla
a idade do pai para startar os filhos e altera sua imageView,
escrve no terminal quando nasce e quando morre, e segura 1sec
a cada um ano de idade
****************************************************************/

package thread;

import control.controllerGeral;

public class threadPai extends Thread {
  controllerGeral cG = new controllerGeral(); // Instanciando e Criando o Controller

  // Metodo Utilizado para Setar um Controlador em Comum em Todas Thread
  public void setControlador(controllerGeral controle) {
    this.cG = controle;
  }

  @Override
  public void run() { // Start RUN
    System.out.println("Pai Nasceu"); // Escreve no Terminal que o pai Nasceu
    try {
      for (int i = 0; i <= 90; i++) { // For até a idade de morte
        if (i == 7) { // verifica a idade e altera a imagem
          cG.UpdateImage("Pai", "assets/Idade2.png");
        }

        if (i == 22) { // verifica a idade e altera a imagem
          cG.UpdateImage("Pai", "assets/Idade3.png");
          cG.StartThread("Filho01"); // Chama a funcao StartThread do controlador e inicializa o Filho01
        }

        if (i == 25) { // verifica a idade para iniciar o filho
          cG.StartThread("Filho02"); // Chama a funcao StartThread do controlador e inicializa o Filho01
        }

        if (i == 32) { // verifica a idade para iniciar o filho
          cG.StartThread("Filho03"); // Chama a funcao StartThread do controlador e inicializa o Filho01
        }

        if (i == 45) { // verifica a idade e altera a imagem
          cG.UpdateImage("Pai", "assets/Idade4.png");
        }

        cG.UpdateAge("Pai", i); // Realiza a Soma da idade por meio do metodo do controlador
        sleep(1000); // segura 1 sec a cada rodagem do for para contar a idade em 90 sec
      } // Fim For
    } catch (InterruptedException e) {
    }
    cG.UpdateImage("Pai", "assets/idade5.png"); // Seta sua imagem de morto quando sai do for
    System.out.println("Pai Morreu aos 90 Anos de Idade"); // Escreve no terminal que o pai morreu
  } // Fim Run

}
