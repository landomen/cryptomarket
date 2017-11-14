package si.lanisnik.cryptomarket.ui.common.mapper;

/**
 * Defines methods for mapping between presentation (view) models and data entity models.
 *
 * @param <D> Data entity type
 * @param <V> Remote model type
 */
public interface ViewModelMapper<D, V> {

    V mapFromData(D data);
}
