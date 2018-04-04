import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;

import strategies.core.IStrategy;

public class ImplementedStrategy implements IStrategy {
	private static final String STRATEGY_NAME = "Random";
	private final String[] ADDITIONAL_PARAMETER_NAMES = {"number_of_choices"};
	
	private int numberOfChoices;
	
	public ImplementedStrategy(HashMap<String, String> additionalParameters) {
		if (additionalParameters == null) {
			return;
		}
		
		if (additionalParameters.containsKey(this.ADDITIONAL_PARAMETER_NAMES[0])) {
			this.numberOfChoices = Integer.parseInt(additionalParameters.get(this.ADDITIONAL_PARAMETER_NAMES[0]));
		}
	}
	
	public int generateChoice(HashMap<String, String> strategyResources) {
		return (int) (Math.random() * this.numberOfChoices);
	}

	@Override
	public void updateStrategy(String key, int value) {
		
	}

	@Override
	public byte[] getIconAsBytes() throws IOException {
		File imageFile = new File("/res/agent_smith_icon.png");
		return Files.readAllBytes(imageFile.toPath());
	}

	@Override
	public String getStrategyName() {
		return STRATEGY_NAME;
	}

	@Override
	public String[] getAdditionalParameterNames() {
		return this.ADDITIONAL_PARAMETER_NAMES;
	}
}
