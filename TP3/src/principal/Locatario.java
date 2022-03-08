package principal;

public class Locatario extends Conta{

	private Reserva[] reservas;
	private CartaoDePagamento[] cartoes;
	
	// Getters e Setters - inicio
	public Reserva[] getReservas() {
		return reservas;
	}

	public void setReservas(Reserva[] reservas) {
		this.reservas = reservas;
	}

	public CartaoDePagamento[] getCartoes() {
		return cartoes;
	}

	public void setCartoes(CartaoDePagamento[] cartoes) {
		this.cartoes = cartoes;
	}
	// Getters e Setters - fim

	

	@Override
	public Boolean alterarConta() {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean excluirConta() {
		return null;
		// TODO Auto-generated method stub
		
	}

}
