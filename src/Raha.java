
public class Raha {

    private final int euroa;
    private final int senttia;

    public Raha(int euroa, int senttia) {

        if (senttia > 99) {
            euroa = euroa + senttia / 100;
            senttia = senttia % 100;
        }

        this.euroa = euroa;
        this.senttia = senttia;
    }

    public int eurot() {
        return this.euroa;
    }

    public int sentit() {
        return this.senttia;
    }

    public Raha plus(Raha lisattava) {
        int uudetEurot = this.euroa + lisattava.euroa;
        int uudetSentit = this.senttia + lisattava.senttia;
    
        if (uudetSentit > 99) {
            uudetEurot += uudetSentit / 100;
            uudetSentit = uudetSentit % 100;
        }
    
        Raha uusi = new Raha(uudetEurot, uudetSentit);
        return uusi;
    }
    

    public boolean vahemman(Raha verrattava) {
        if (this.euroa < verrattava.euroa) {
            return true;
        } else if (this.euroa == verrattava.euroa && this.senttia < verrattava.senttia) {
            return true;
        }
        return false;
    }

    public Raha miinus(Raha vahennettava) {
        int uudetEurot = this.euroa - vahennettava.euroa;
        int uudetSentit = this.senttia - vahennettava.senttia;
    
        if (uudetSentit < 0) {
            uudetEurot -= 1;
            uudetSentit += 100;
        }
    
        if (uudetEurot < 0) {
            uudetEurot = 0;
            uudetSentit = 0;
        }
    
        return new Raha(uudetEurot, uudetSentit);
    }
    

    public String toString() {
        String nolla = "";
        if (this.senttia < 10) {
            nolla = "0";
        }

        return this.euroa + "." + nolla + this.senttia + "e";
    }

}
