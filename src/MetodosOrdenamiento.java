/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Trix
 */
public class MetodosOrdenamiento {
    int i,j,temp;
    public MetodosOrdenamiento(){
        this.i=0;
        this.j=0;
        this.temp=0;
    }
    
    public String Burbuja(int m[]){
        for (int i = 0; i < m.length; i++) {
            for (int j = i+1; j < m.length; j++) {
                if(m[i]>m[j]){
                temp=m[i];
                m[i]=m[j];
                m[j]=temp;
                }
            }
        }
        return mostring(m);
     }
    
    public String quick(int m[],int primero, int ultimo){
        int i,j,pivote,aux;
        i=primero;
        j=ultimo;
        pivote = m[(primero+ultimo)/2];
        //System.out.println("EL pivote es: "+pivote);
        do{
            while(m[i]<pivote){
                i++;
            }
            while(m[j]>pivote){
                j--;
            }
            //inicia el intercambio.
            if(i<=j){
                aux=m[i];
                m[i]=m[j];
                m[j]=aux;
                i++;
                j--;
            }
        }while(i<=j);
        if(primero<j){
            quick(m , primero , j);
        }
        if(i<ultimo){
            quick(m , i , ultimo);
        }
        mostrar(m);
        return mostring(m);
    }
    
    public String Shell(int A[]) {
        int salto, aux, i;
        boolean cambios;

        for (salto = A.length / 2; salto != 0; salto /= 2) {
            cambios = true;
            while (cambios) {                        // Mientras se intercambie algún elemento
                cambios = false;
                for (i = salto; i < A.length; i++)   // se da una pasada
                {
                    if (A[i - salto] > A[i]) {       // y si están desordenados
                        aux = A[i];                  // se reordenan
                        A[i] = A[i - salto];
                        A[i - salto] = aux;
                        cambios = true;              // y se marca como cambio.
                    }
                }
            }
        }
        return mostring(A);
    }
    
    public String Radix(int m[]){
        int x,i,j;
        for (x = Integer.SIZE - 1 ; x > 0 ; x--) {
            int aux[]=new int[m.length];
            j=0;
            for (i = 0; i < m.length; i++) {
                
                boolean mover = m[i]<< x >=0;
                if(x==0 ? !mover : mover){
                    aux[j] = m[i];
                    j++;
                }else{
                    m[i-j] = m[i];
                }   
            }for (i = j;  i<aux.length; i++) {
                aux[i] = m[i-j];
            }
            m=aux;   
        }
        return mostring(m);
    }
    
    public String Intercalacion(int m1[],int m2[]){
        int i,j,k;
        int m3[]=new int[m1.length+m2.length];
        //El proceso se repite cuando a y b tengan elementos a comparar.
        for (i = j = k = 0 ;  i < m1.length && j < m2.length ; k++) {
            if(m1[i] < m2[j]){
                m3[k]=m1[i];
                i++;
            }else{
                m3[k]=m2[j];
                j++;
            }
        }
        //Cuando se añaden los elementos de un arreglo sobrante hacemos:
        for ( ; i<m1.length ; i++ , k++){
            m3[k]=m1[i];
        }
        for ( ; j < m2.length ; j++ , k++){
            m3[k]=m2[j];
        }
        return mostring(m3);
    }
    
        public int[] mezclaDirecta(int []numeros){
         int i,j,k;
         if(numeros.length > 1){
            int nElementosIzq = numeros.length/2;
            int nElementosDer = numeros.length - nElementosIzq;
            int arregloIzq[] = new int[nElementosIzq];
            int arregloDer[] = new int[nElementosDer];
             
            for(i = 0; i < nElementosIzq; i++){
                arregloIzq[i] = numeros[i];
            }
             
            for(i = nElementosIzq; i < nElementosIzq + nElementosDer; i++){
                arregloDer[i - nElementosIzq] = numeros[i];
            }
             
            arregloIzq = mezclaDirecta(arregloIzq);
            arregloDer = mezclaDirecta(arregloDer);
            
            i = 0;
            j = 0;
            k = 0;
            
            while(arregloIzq.length != j && arregloDer.length != k){
                if(arregloIzq[j] < arregloDer[k]){
                    numeros[i] = arregloIzq[j];
                    i++;
                    j++;
                } else{
                    numeros[i] = arregloDer[k];
                    i++;
                    k++;
                }
            }
            while(arregloIzq.length != j){
                numeros[i] = arregloIzq[j];
                    i++;
                    j++;   
            }
            while(arregloDer.length != k){
                numeros[i] = arregloDer[k];
                    i++;
                    k++;   
            }
         }
         return numeros; 
    }
        
        public void mezclaDirecta2(int []numeros){
         int i,j,k;
         if(numeros.length > 1){
            int nElementosIzq = numeros.length/2;
            int nElementosDer = numeros.length - nElementosIzq;
            int arregloIzq[] = new int[nElementosIzq];
            int arregloDer[] = new int[nElementosDer];
             
            for(i = 0; i < nElementosIzq; i++){
                arregloIzq[i] = numeros[i];
            }
             
            for(i = nElementosIzq; i < nElementosIzq + nElementosDer; i++){
                arregloDer[i - nElementosIzq] = numeros[i];
            }
             
            arregloIzq = mezclaDirecta(arregloIzq);
            arregloDer = mezclaDirecta(arregloDer);
            
            i = 0;
            j = 0;
            k = 0;
            
            while(arregloIzq.length != j && arregloDer.length != k){
                if(arregloIzq[j] < arregloDer[k]){
                    numeros[i] = arregloIzq[j];
                    i++;
                    j++;
                } else{
                    numeros[i] = arregloDer[k];
                    i++;
                    k++;
                }
            }
            
            while(arregloIzq.length != j){
                numeros[i] = arregloIzq[j];
                    i++;
                    j++;   
            }
            
            while(arregloDer.length != k){
                numeros[i] = arregloDer[k];
                    i++;
                    k++;   
            }
         }
         
    }
        public int[] mezclaNatural(int arreglo[]){
        int izquierda = 0, izq = 0, derecha = arreglo.length-1,der  = derecha;
        boolean ordenado = false;
        do{
            ordenado=true;
            izquierda = 0;
            while ( izquierda < derecha) {
                izq = izquierda;
                while (izq < derecha && arreglo[izq] <= arreglo[izq + 1]){
                    izq++;
            }
            der = izq + 1;
            while (der == derecha-1 || der < derecha && arreglo[der] <= arreglo[der+1]){
                der++;
            }
            if(der <= derecha){
                mezclaDirecta2(arreglo);
                ordenado = false;
            }
            izquierda = izq;
        }
    } while (!ordenado);
        return arreglo;
    }
     
        
        
     public String mostrar(int[] numeros) {
        int k=0;String cad="";
         for (k = 0; k < numeros.length; k++) {
             System.out.print("["+numeros[k]+"]");
             cad+="["+numeros[k]+"]";
         }
         System.out.println();
         cad+="\n";
         return cad;
     }
     
    public String mostring(int[]numeros){
        int k=0;String cad="";
         for (k = 0; k < numeros.length; k++) {
             cad+="["+numeros[k]+"]";
         }
         cad+="\n";
         return cad;
    }
}
