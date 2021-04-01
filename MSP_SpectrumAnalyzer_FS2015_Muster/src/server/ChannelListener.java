package server;
/**
 * Instances of ChannelListeners can receive the sampled data of the channel
 * they have been registered.
 * 
 * @see Sampler
 */
public interface ChannelListener {

	public void process(double[] data);
}
