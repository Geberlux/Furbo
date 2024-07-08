
import javax.swing.JOptionPane;
public class Jugador {
	private String nombre;
	private String pais;
	private double peso;
	private int categoria;
	private int edad;
	private int nCamiseta;
	public Jugador(String nombre, String pais, double peso, int categoria, int edad, int nCamiseta) {
		
		this.nombre = nombre;
		this.pais = pais;
		this.peso = peso;
		this.categoria = categoria;
		this.edad = edad;
		this.nCamiseta =  nCamiseta;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public int getCategoria() {
		return categoria;
	}
	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public int getnCamiseta() {
		return nCamiseta;
	}
	public void setnCamiseta(int nCamiseta) {
		this.nCamiseta = nCamiseta;
	}
	@Override
	public String toString() {
		return "\nJugador [nombre=" + nombre + ", pais=" + pais + ", peso=" + peso + ", categoria=" + categoria
				+ ", edad=" + edad + ", nCamiseta=" + nCamiseta + "]";
	}
	public Jugador(){
		nombre="";
		edad=0;
		
	}
	public boolean ValidadJugador() {
		edad=Integer.parseInt(JOptionPane.showInputDialog("Ingresar edad."));
		if (edad<=18) {
			JOptionPane.showInputDialog("No puede participar porque es menor de edad");
			return false;
		} else if (peso>=110 || categoria>=110 || peso<=55 ||categoria<=55) {
			JOptionPane.showInputDialog("No puede participar por no cumplir con las categorias");
			return false;
		}else{
			return true;
		}
	
	}
}