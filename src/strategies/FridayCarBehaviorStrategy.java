package strategies;

public class FridayCarBehaviorStrategy implements CarBehavior {

    @Override
    public void drive() {
        System.out.println("Uso de dia VIERNES para ser un agente secreto \uD83D\uDD75\uFE0F\u200D♂\uFE0F");
        this.activateFireGuns();
        this.activateCamouflage();
    }

    private void activateFireGuns(){
        System.out.println("Armas de fuego activadas! 🔫");
    }

    private void activateCamouflage(){
        System.out.println("Camuflaje activado! 🕵️‍♂️");
    }
}
