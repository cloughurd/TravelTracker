package models.provider;
/*
This class allows for the swapping of providers for testing. Returns the established provider.
 */
public class ProviderFactory {
    private static ISingleProvider provider = null;

    public static void setProvider(ISingleProvider newProvider){
        provider = newProvider;
    }

    public static ISingleProvider getProvider(){
        if(provider == null){
            provider = SingleProvider.getInstance();
        }
        return provider;
    }
}
