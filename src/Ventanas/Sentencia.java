/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ventanas;

/**
 *
 * @author Admin
 */
public class Sentencia {
    
    public String sentenciaName;
    public int linea;
    public int Numsent;
    
    public Sentencia(String sentenciaName, int linea, int numsent){
        this.sentenciaName = sentenciaName;
        this.linea = linea;
        this.Numsent = numsent;
    }
    
    public int CompareTo(Sentencia other){
        return (this.linea == other.linea) ? 1 : 0;
    }
    
    private void buscarBloque(String linea2, int lineaCierra)
        {
            String[] condicionales = { "==", "!=", "<=", ">=", ">", "<", "true", "false" };
            String[] condicionalesNegados = { "!=", "==", ">", "<", "<=", ">=", "false", "true" };
            if ((linea2.contains("if(") || linea2.contains("while(")) && linea2.contains("{"))
            {

                linea2 = Regex.replace(linea2, @"\s", "");
                if (linea2.contains("if("))
                {
                    this.startPila = true;
                    this.pila.Push("if");
                }
                else
                {
                    this.startPila = true;
                    this.pila.Push("while");
                }

                int position1 = linea2.IndexOf("(");
                int position2 = linea2.IndexOf(")");
                int position3 = position2 - position1 + 1;
                String clausula = linea2.Substring(position1, position3);
                for (int i = 0; i < condicionales.Length; i++)
                {
                    if (clausula.contains(condicionales[i]))
                    {
                        clausula = clausula.Replace(condicionales[i], condicionalesNegados[i]);
                        this.pila.Push(clausula);
                        break;
                    }
                }
                this.pila.Push(lineaCierra);
               // this.numSent++;
            }
            else if (linea2.Contains("}") && !linea2.Contains("until"))
            {
                if (this.pila.Count > 1)
                {
                    int nLinea = (int)this.pila.Pop();
                    Object condicional = this.pila.Pop();
                    Object instruccion = this.pila.Pop();

                    if( this.pila.Count == 0)
                    {
                        this.imprimirPila = true;
                    }

                    //this.fases.Text += nLinea + "   " + instruccion + condicional + " goto " + lineaCierra + Environment.NewLine;
                    this.array.Add(new Sentencia(" "+instruccion + condicional + " goto " + lineaCierra, nLinea, this.numSent));
                    this.startPila = false;
                  

                }
            }
            else if (linea2.Contains("do") && linea2.Contains("{"))
            {
                
                this.pilaDo.Push(lineaCierra);
            }
            else if (linea2.Contains("until"))
            {
                this.startPila = true;
                int position1 = linea2.IndexOf("(");
                int position2 = linea2.IndexOf(")");
                int position3 = position2 - position1 + 1;
                String clausula = linea2.Substring(position1, position3);
                for (int i = 0; i < condicionales.Length; i++)
                {
                    if (clausula.Contains(condicionales[i]))
                    {
                        this.pilaDo.Push(clausula);
                        break;
                    }
                }
                Object clausulaDo = this.pilaDo.Pop();
                int lineaDo = (int)this.pilaDo.Pop();
                if(this.pilaDo.Count == 0)
                {
                    this.imprimirPila = true;
                }
                //this.fases.Text += lineaDo + " if" + clausulaDo + " goto " + lineaDo;
                this.array.Add(new Sentencia(lineaCierra + " until" + clausulaDo + " goto " + lineaDo, lineaCierra, this.numSent));
                this.startPila = false;
               
            }

        }
    
    public static void main(String args[]){
        
    }
    
}
