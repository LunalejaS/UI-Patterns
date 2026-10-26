import content.ProgressiveDisclosure;
import input.ForgivenFormat;
import navigation.BreadcrumbsPattern;
import state.CompletenessMeter;
import state.LazyRegistration;
import state.Toast;

public class App {

    public static void main(String[] args) {
        showNavigation();
        showProgressiveDisclosure();
        String phone = showForgivingFormat();
        CompletenessMeter meter = showCompletenessMeter(phone);
        showLazyRegistrationAndToast();
    }

    private static void showNavigation() {
        System.out.println("--- 1. PATRÓN DE NAVEGACIÓN (BREADCRUMBS) ---");
        BreadcrumbsPattern nav = new BreadcrumbsPattern("Inicio");
        nav.navigateTo("Catálogo");
        nav.navigateTo("Servidor Principal");
        System.out.println("Ruta actual: " + nav.render());
        System.out.println();
    }

    private static void showProgressiveDisclosure() {
        System.out.println("--- 2. PATRÓN DE CONTENIDO Y ESTRUCTURA (PROGRESSIVE DISCLOSURE) ---");
        ProgressiveDisclosure card = new ProgressiveDisclosure(
                "Servidor Principal",
                "Estado: Activo",
                "IP: 192.168.1.10 | Puerto: 8080 | RAM: 4GB/16GB"
        );
        card.showInformation();
        System.out.println("[Usuario solicita ver detalles avanzados...]");
        card.toggle();
        card.showInformation();
        System.out.println();
    }

    private static String showForgivingFormat() {
        System.out.println("--- 3. PATRÓN DE ENTRADA DE DATOS (FORGIVING FORMAT) ---");
        ForgivenFormat format = new ForgivenFormat();
        String rawPhone = "+57 (300) 123-4567";
        System.out.println("Entrada del usuario: \"" + rawPhone + "\"");
        String digits = format.normalizeFormat(rawPhone);
        if (format.isValid(digits)) {
            System.out.println("Teléfono normalizado sin error: \"" + digits + "\"");
        } else {
            System.out.println("Número no válido: \"" + rawPhone + "\"");
        }
        System.out.println();
        return digits;
    }

    private static CompletenessMeter showCompletenessMeter(String phone) {
        System.out.println("--- 4. PATRÓN DE FEEDBACK Y ESTADO (COMPLETENESS METER) ---");
        CompletenessMeter meter = new CompletenessMeter("Nombre", "Teléfono", "Correo de contacto");
        meter.markCompleted("Nombre");
        meter.markCompleted("Teléfono");
        System.out.println(meter.render());
        String email = "estudiante@udistrital.edu.co";
        System.out.println("Usuario ingresa correo: \"" + email + "\"");
        meter.markCompleted("Correo de contacto");
        System.out.println(meter.render());
        if (meter.getPercentage() == 100) {
            System.out.println("¡Formulario completo!");
        }
        System.out.println();
        return meter;
    }

    private static void showLazyRegistrationAndToast() {
        System.out.println("--- 5. LAZY REGISTRATION + TOAST ---");
        LazyRegistration session = new LazyRegistration();
        Toast toast = new Toast();

        System.out.println("Usuario intenta guardar sin haber iniciado sesión...");
        if (!session.isRegistered()) {
            toast.push(Toast.Type.INFO, "Avance guardado en borrador temporal. Por favor cree su cuenta para finalizar.");
            printToasts(toast);
        }

        session.register("Estudiante");
        System.out.println("Usuario completa registro rápido -> Sesión activa = " + session.isRegistered());

        if (session.isRegistered()) {
            toast.push(Toast.Type.SUCCESS, "Reserva guardada exitosamente.");
            printToasts(toast);
        }
    }

    private static void printToasts(Toast toast) {
        while (toast.hasPending()) {
            System.out.println(toast.next());
        }
    }
}