package one.digitalinnovation;

import java.util.Objects;

public class Obj implements Comparable<Obj> {

    Integer meuValor;

    public Obj(Integer meuValor) {
        this.meuValor = meuValor;
    }

    @Override
    public int compareTo(Obj outro) {
        return this.meuValor > outro.meuValor?
                1 : this.meuValor < outro.meuValor?
                    -1 :
                        0;
    }

    @Override
    public String toString() {
        return meuValor.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Obj)) return false;
        Obj that = (Obj) o;
        return Objects.equals(meuValor, that.meuValor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(meuValor);
    }
}
