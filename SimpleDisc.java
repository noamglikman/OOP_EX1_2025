public class SimpleDisc implements Disc{
    private Player owner;  // Store the player who owns this disc

    // Constructor that sets the owner of the disc
    public SimpleDisc(Player currentPlayer) {
        this.owner = currentPlayer;
    }

    // Return the owner of the disc
    @Override
    public Player getOwner() {
        return owner;
    }

    // Set the owner of the disc
    @Override
    public void setOwner(Player player) {
        this.owner = player;
    }

    // Return the type of the disc as a string
    @Override
    public String getType() {
        return "⬤";
    }
}
