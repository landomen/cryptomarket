package si.lanisnik.cryptomarket.data.source.remote.mapper;

/**
 * Defines methods for mapping between remote models and data entity models.
 *
 * @param <D> Data entity type
 * @param <R> Remote model type
 */
public interface RemoteModelMapper<D, R> {

    D mapFromRemote(R remote);
}
