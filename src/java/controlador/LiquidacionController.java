package controlador;

import modelo.entidad.Liquidacion;
import controlador.util.JsfUtil;
import controlador.util.JsfUtil.PersistAction;
import modelo.dao.LiquidacionFacade;

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

@Named("liquidacionController")
@SessionScoped
public class LiquidacionController implements Serializable {

    @EJB
    private modelo.dao.LiquidacionFacade ejbFacade;
    private List<Liquidacion> items = null;
    private Liquidacion selected;

    public LiquidacionController() {
    }

    public Liquidacion getSelected() {
        return selected;
    }

    public void setSelected(Liquidacion selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private LiquidacionFacade getFacade() {
        return ejbFacade;
    }

    public Liquidacion prepareCreate() {
        selected = new Liquidacion();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/vista").getString("LiquidacionCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/vista").getString("LiquidacionUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/vista").getString("LiquidacionDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Liquidacion> getItems() {
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

    public Liquidacion getLiquidacion(java.math.BigDecimal id) {
        return getFacade().find(id);
    }

    public List<Liquidacion> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Liquidacion> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Liquidacion.class)
    public static class LiquidacionControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            LiquidacionController controller = (LiquidacionController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "liquidacionController");
            return controller.getLiquidacion(getKey(value));
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
            if (object instanceof Liquidacion) {
                Liquidacion o = (Liquidacion) object;
                return getStringKey(o.getCodliq());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Liquidacion.class.getName()});
                return null;
            }
        }

    }

}
