package controlador;

import modelo.entidad.Juzgado;
import controlador.util.JsfUtil;
import controlador.util.JsfUtil.PersistAction;
import modelo.dao.JuzgadoFacade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("juzgadoController")
@SessionScoped
public class JuzgadoController implements Serializable {

    @EJB
    private modelo.dao.JuzgadoFacade ejbFacade;
    private List<Juzgado> items = null;
    private Juzgado selected;

    public JuzgadoController() {
    }

    public Juzgado getSelected() {
        return selected;
    }

    public void setSelected(Juzgado selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private JuzgadoFacade getFacade() {
        return ejbFacade;
    }

    public Juzgado prepareCreate() {
        selected = new Juzgado();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/vista").getString("JuzgadoCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/vista").getString("JuzgadoUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/vista").getString("JuzgadoDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Juzgado> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/vista").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/vista").getString("PersistenceErrorOccured"));
            }
        }
    }

    public Juzgado getJuzgado(java.math.BigDecimal id) {
        return getFacade().find(id);
    }

    public List<Juzgado> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Juzgado> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Juzgado.class)
    public static class JuzgadoControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            JuzgadoController controller = (JuzgadoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "juzgadoController");
            return controller.getJuzgado(getKey(value));
        }

        java.math.BigDecimal getKey(String value) {
            java.math.BigDecimal key;
            key = new java.math.BigDecimal(value);
            return key;
        }

        String getStringKey(java.math.BigDecimal value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Juzgado) {
                Juzgado o = (Juzgado) object;
                return getStringKey(o.getCodjuz());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Juzgado.class.getName()});
                return null;
            }
        }

    }

}
