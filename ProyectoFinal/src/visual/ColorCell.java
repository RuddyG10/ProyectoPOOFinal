package visual;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

import logico.Altice;
import logico.Cliente;
import logico.Factura;
import logico.Plan;

public class ColorCell extends JTable {
	public Component prepareRenderer(TableCellRenderer renderer,int rowInder, int columnIndex) {
		Component componente = super.prepareRenderer(renderer, rowInder, columnIndex);
		if(getValueAt(rowInder, 0).getClass().equals(String.class)) {
			String code = String.valueOf(this.getValueAt(rowInder, 0));
			Cliente client = Altice.getInstance().buscarClientePorCedula(code);
			ArrayList<Factura> facturas = client.getMisFacturas();
		if(Altice.getInstance().cantFacturasPendientes(client) >= 3) {
			componente.setBackground(Color.red);
		}
		if(Altice.getInstance().cantFacturasPendientes(client)<3 && Altice.getInstance().cantFacturasPendientes(client)>0 ) {
			componente.setBackground(Color.yellow);
		}
		if(Altice.getInstance().cantFacturasPendientes(client)==0) {
			componente.setBackground(Color.green);
		}
			
		}
		return componente;
	}
}
