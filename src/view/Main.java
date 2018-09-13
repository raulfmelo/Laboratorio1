 package view;
 
 import javax.swing.JOptionPane;
 import model.Vendas;
 
 public class Main {
 	
 	public static void main(String[] args){
 		Vendas vendas;
 		int fileira = 0;
 		int assento = 0;
 		int inteira;
 		boolean vendeu;
 		
 		vendas = new Vendas();
 		
		do { 
			JOptionPane.showMessageDialog(null, "Temos " +model.Ingresso.getQuantidade() + " ingressos disponiveis.", "Ingressos do Teatro POO", JOptionPane.INFORMATION_MESSAGE);
			JOptionPane.showMessageDialog(null, "Vendas de ingressos", "Ingressos do Teatro POO", JOptionPane.INFORMATION_MESSAGE);
			fileira = Integer.parseInt(JOptionPane.showInputDialog("Fileira", 0));
			assento = Integer.parseInt(JOptionPane.showInputDialog("Assento", 0));
			inteira = JOptionPane.showConfirmDialog(null, "Ingresso pre�o integral?", "Ingressos do Teatro POO", JOptionPane.YES_NO_OPTION);
			if(inteira == JOptionPane.YES_NO_OPTION){
				vendeu = vendas.novaVenda(fileira, assento, Vendas.INTEIRA);
			}else {
 				inteira = JOptionPane.showConfirmDialog(null, "Ingresso Isento?", "Ingressos do Teatro POO", JOptionPane.YES_NO_OPTION);
 					if(inteira == JOptionPane.YES_NO_OPTION) {
 						vendeu = vendas.novaVenda(fileira, assento, Vendas.ISENTO);
 					}
 					else
 						vendeu = vendas.novaVenda(fileira, assento, Vendas.MEIA);
 			}
 			
			if(!vendeu) {
				JOptionPane.showMessageDialog(null,  "Cadeira ocupada", "Ingresso do Teatro POO", JOptionPane.ERROR_MESSAGE);
			}else {
				JOptionPane.showMessageDialog(null,  "Bom espet�culo", "Ingresso do Teatro POO", JOptionPane.WARNING_MESSAGE);
			}
			
		}while(JOptionPane.showConfirmDialog(null,  "Deseja encerrar o sistema?", "Ingressos do Teatro POO", JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION);
 		JOptionPane.showMessageDialog(null,  "Total de vendas: R$" + vendas.valorArrecadado(), "Teatro POO", JOptionPane.INFORMATION_MESSAGE);
 		}
 	}
 