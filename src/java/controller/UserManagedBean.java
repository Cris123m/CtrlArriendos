package controller;

import com.leydi.jsf.Arrendador;
import com.leydi.jsf.Arrendatarios;
import com.leydi.jsf.Departamentos;
import com.leydi.jsf.Pagos;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Collection;
import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.servlet.http.HttpSession;

@Named(value = "userManagedBean")
@SessionScoped
public class UserManagedBean implements Serializable {

    /**
     * Creates a new instance of UserManagedBean
     */
    private String code;

    private int tipo;
    private String cedula;
    private String password;
    
    private @EJB ArrendatariosFacade arrendatario_services;
    private @EJB ArrendadorFacade arrendador_services;
    private @EJB DepartamentosFacade departamento_services;
    private @EJB PagosFacade pago_services;
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    Arrendatarios arrendatario = new Arrendatarios();
    Departamentos departamento = new Departamentos();
    Pagos pago = new Pagos();

    Arrendador arrendador = new Arrendador();
    ArrendadorController arrendadorDAO = new ArrendadorController();

    public UserManagedBean() {
        code = "XULES-CODE";
        System.out.println("Validation code (Código de validación): " + code);
    }

    public String getValidation() {
        try {
            if (tipo != 0) {
                FacesContext context = FacesContext.getCurrentInstance();
                HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
                ExternalContext ec = context.getExternalContext();
                session.invalidate();
                if (tipo == 1) {
                    try {                        
                        arrendatario = arrendatario_services.find(cedula);
                        departamento = arrendatario.getDepartamentoId();
                        Collection<Pagos> ps = arrendatario.getPagosCollection();
                    } catch (Exception e) {
                        System.err.print("Err: "+e.getMessage());
                    }
                    
                    if (!arrendatario.getNombres().isEmpty()) {
                        String resultado = "<p>" + arrendatario.getNombres() +" "+arrendatario.getApellidos()+ " es arrendatario ";
                        resultado += "del departamento " + departamento.getPiso()+" "+departamento.getLetra()+ "</p>";
                        return resultado;
                    }else{
                        return "<p>Arrendatario No válido</p>";
                    }

                } else if (tipo == 2) {
                    arrendador = arrendador_services.find(cedula);
                    if (arrendador.getClave().equals(password)) {
                        ec.redirect(ec.getRequestContextPath()
                                + "/faces/departamentos/List.xhtml");
                        //return "<p>"+arrendador.getNombres()+"Es arrendador</p>";
                    } else {
                        return "<p>No es  arrendador</p>";
                    }

                }
            } else {
                return "<p>No válido</p>";
            }
        } catch (Exception e) {
            System.out.println("Error en UserManagedBean: "+e.getMessage());
        }
//        if ((validationCode != null) && (validationCode.compareTo(code) == 0)) {
//            // The validationCode is OK then we show the user data in validation.xhtml
//            // El código validationCode es correcto entonces mostramos los datos en validation.xhtm
//            FacesContext context = FacesContext.getCurrentInstance();
//            HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
//            session.invalidate();
//            return "<p>User accepted:</p>"
//                    + "<ul>"
//                    + " <li>User: " + getUser() + " </li>"
//                    + " <li>Nick name: " + getNickName() + " </li>"
//                    + " <li>Email: " + getEmail() + " </li>"
//                    + "</ul>";
//        } else {
//            return "<p>Sorry, " + validationCode + " isn't valid.</p>"
//                    + "<p>Try again...</p>";
//        }
        return "";
    }
}
