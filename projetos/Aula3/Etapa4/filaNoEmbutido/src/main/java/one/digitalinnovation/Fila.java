package one.digitalinnovation;

public class Fila {

    private No refNoEntradaFila = null;

    public void enqueue(Object obj){ <----------------------------------------------
        No novoNo = new No(obj); <----------------------------------------------
        novoNo.setRefNo(refNoEntradaFila);
        refNoEntradaFila = novoNo;
    }

    public Object dequeue(){
        if(!isEmpty()){
            No primeiroNo = refNoEntradaFila;
            No noAuxiliar = refNoEntradaFila;
            while(true){
              if(primeiroNo.getRefNo() != null) {
                  noAuxiliar = primeiroNo;
                  primeiroNo = primeiroNo.getRefNo();
              }else{
                  noAuxiliar.setRefNo(null);
                  break;
              }
            }
            return primeiroNo.getObject(); <----------------------------------------------
        }
        return null;
    }

    public Object first(){
        if(!isEmpty()){
            No primeiroNo = refNoEntradaFila;
            while(true){
                if(primeiroNo.getRefNo() != null) {
                    primeiroNo = primeiroNo.getRefNo();
                }else{
                    break;
                }
            }
            return primeiroNo.getObject(); <----------------------------------------------
        }
        return null;
    }

    public boolean isEmpty(){
        return refNoEntradaFila == null ? true : false;
    }

    @Override
    public String toString() {
        String stringRetorno = "";
        No noAuxiliar = refNoEntradaFila;

        if(refNoEntradaFila != null){
            while(true){
                stringRetorno += "[No{dado="+ noAuxiliar.getObject() +"}]--->";
                if(noAuxiliar.getRefNo() != null){
                    noAuxiliar = noAuxiliar.getRefNo();
                }else{
                    stringRetorno += "null";
                    break;
                }
            }
        }else{
            stringRetorno = "null";
        }

        return stringRetorno;
    }
}
