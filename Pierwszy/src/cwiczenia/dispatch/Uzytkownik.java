package cwiczenia.dispatch;

public class Uzytkownik {
	
	//Java Bean (prywatne atrybuty i konstruktor bezparametrowy domyślny, najpierw getter potem setter 
	//jeżeli w pliku index.jsp będziemy się odwoływać do atrybutu np. imie to dlatego, że tak zbudowana jest konwencja JavaBean get[Imie] 
	
	private int idUser;
	private String imie;
	private String nazwisko;
	
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getImie() {
		return imie;
	}
	public void setImie(String imie) {
		this.imie = imie;
	}
	public String getNazwisko() {
		return nazwisko;
	}
	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}
	
	
}
