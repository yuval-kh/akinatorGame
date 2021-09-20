package interfaces;

/**Class interfaces.HitNotifier.
 * describing hit events.
 *  @author Yuval Khanimov
 *  <yuval953@gmail.com>
 *  ID 318970902 */
public interface HitNotifier {
    /**
     *  Add hl as a listener to hit events.
     * @param hl the hit listener.
     */
    void addHitListener(HitListener hl);
     /**
     * Remove hl from the list of listeners to hit events.
     * @param hl the hit listener.
     */
    void removeHitListener(HitListener hl);
}