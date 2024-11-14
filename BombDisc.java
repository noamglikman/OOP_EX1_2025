public class BombDisc implements Disc {
private Player owner;
private final String type = "BumnbDisc";  // The type of the disc (fixed for SimpleDisc)
    public BombDisc(Player currentPlayer) {
    this.owner=currentPlayer;
    }

    @Override
    public Player getOwner() {
        return owner;
    }

    @Override
    public void setOwner(Player player) {
      this.owner=player;
    }

    @Override
    public String getType() {
        return  "💣";
    }
}
