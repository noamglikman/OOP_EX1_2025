public class UnflippableDisc implements Disc{
    private Player owner;  // Store the player who owns this disc
    private final String type = "SimpleDisc";  // The type of the disc (fixed for SimpleDisc)

    public UnflippableDisc(Player currentPlayer) {
        this.owner=currentPlayer;
    }

    @Override
    public Player getOwner() {
        return owner;
    }

    @Override
    public void setOwner(Player player){
     this.owner=player;
    }

    @Override
    public String getType() {
        return "⭕" ;
    }
}
