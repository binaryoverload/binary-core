package es.esy.williamoldham.binarycore.design;

/**
 * Design which compartmentalises functions
 *
 * @author BinaryOverload
 * @since 1.5.0
 * @version 1.0.0
 *
 */
public interface SimpleDesign {

    /**
     * Initializes variables and objects.
     *
     * @since 1.5.0
     */
    void init();

    /**
     * Loads data into the object
     *
     * @since 1.5.0
     */
    void load();

    /**
     * Occurs just after the object loads data.
     *
     * @since 1.5.0
     */
    void postload();

    /**
     * Occurs just before the object loads data.
     *
     * @since 1.5.0
     */
    void preload();

    /**
     * Registers listeners and commands.
     *
     * @since 1.5.0
     */
    void register();

    /**
     * Saves object data.
     *
     * @since 1.5.0
     */
    void save();

    /**
     * Schedules tasks.
     *
     * @since 1.5.0
     */
    void schedule();

    /**
     * Unregisters tasks, listeners and commands.
     *
     * @since 1.5.0
     */
    void unregister();

}
