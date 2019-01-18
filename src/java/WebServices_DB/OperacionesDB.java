/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebServices_DB;

import Controladores.CuentasJpaController;
import Controladores.DinerosJpaController;
import Entidades.Dineros;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author xcojcama
 */
public class OperacionesDB {

    public String Transacion(String cuenta, int dinero) {
        String msg = null;
        CuentasJpaController CCuenta = new CuentasJpaController();
        DinerosJpaController CDinero = new DinerosJpaController();
        int idCuneta = CCuenta.IdCuentas(cuenta);

        try {

            Dineros din = null;
            List<Dineros> dins = CDinero.GetIdDinero();

            for (Dineros str : dins) {

                if (Objects.equals(str.getIDCuentas().getIDCuentas(), idCuneta)) {
                    din = str;
                }
            }

            int valor = din.getValoractual();

            if (valor < dinero) {
                msg = "No tiene saldo suficiente";
            } else {
                din.setValoractual(valor - dinero);
                CDinero.edit(din);
                msg = "Se realizo la debito a su cuenta";
            }

        } catch (Exception e) {
        }
        return msg;
    }
}
