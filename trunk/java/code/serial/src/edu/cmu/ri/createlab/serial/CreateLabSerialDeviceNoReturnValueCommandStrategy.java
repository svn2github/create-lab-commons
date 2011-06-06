package edu.cmu.ri.createlab.serial;

/**
 * @author Chris Bartley (bartley@cmu.edu)
 */
public abstract class CreateLabSerialDeviceNoReturnValueCommandStrategy extends CreateLabSerialDeviceCommandStrategy
   {
   /**
    * Creates a <code>CreateLabSerialDeviceNoReturnValueCommandStrategy</code> using the default values for read
    * timeout, slurp timeout, and max retries.
    *
    * @see CreateLabSerialDeviceCommandStrategy#CreateLabSerialDeviceCommandStrategy()
    * @see CreateLabSerialDeviceCommandStrategy#DEFAULT_READ_TIMEOUT_MILLIS
    * @see CreateLabSerialDeviceCommandStrategy#DEFAULT_SLURP_TIMEOUT_MILLIS
    * @see CreateLabSerialDeviceCommandStrategy#DEFAULT_MAX_NUMBER_OF_RETRIES
    */
   protected CreateLabSerialDeviceNoReturnValueCommandStrategy()
      {
      super();
      }

   /**
    * Creates a <code>CreateLabSerialDeviceNoReturnValueCommandStrategy</code> using the given value for read timeout
    * and the default values for slurp timeout and max retries.
    *
    * @see CreateLabSerialDeviceCommandStrategy#CreateLabSerialDeviceCommandStrategy(int)
    * @see CreateLabSerialDeviceCommandStrategy#DEFAULT_READ_TIMEOUT_MILLIS
    * @see CreateLabSerialDeviceCommandStrategy#DEFAULT_SLURP_TIMEOUT_MILLIS
    * @see CreateLabSerialDeviceCommandStrategy#DEFAULT_MAX_NUMBER_OF_RETRIES
    */
   protected CreateLabSerialDeviceNoReturnValueCommandStrategy(final int readTimeoutMillis)
      {
      super(readTimeoutMillis);
      }

   /**
    * Creates a <code>CreateLabSerialDeviceNoReturnValueCommandStrategy</code> using the given values for read timeout, 
    * slurp timeout, and max retries.
    *
    * @see CreateLabSerialDeviceCommandStrategy#CreateLabSerialDeviceCommandStrategy(int, int, int)
    * @see CreateLabSerialDeviceCommandStrategy#DEFAULT_READ_TIMEOUT_MILLIS
    * @see CreateLabSerialDeviceCommandStrategy#DEFAULT_SLURP_TIMEOUT_MILLIS
    * @see CreateLabSerialDeviceCommandStrategy#DEFAULT_MAX_NUMBER_OF_RETRIES
    */
   protected CreateLabSerialDeviceNoReturnValueCommandStrategy(final int readTimeoutMillis, final int slurpTimeoutMillis, final int maxNumberOfRetries)
      {
      super(readTimeoutMillis, slurpTimeoutMillis, maxNumberOfRetries);
      }

   @Override
   public final SerialDeviceCommandResponse execute(final SerialDeviceIOHelper ioHelper)
      {
      // get the command to be written
      final byte[] command = getCommand();

      // write the command and check for the command echo
      final boolean wasSuccessful = writeCommand(ioHelper, command);

      // return the response
      return new SerialDeviceCommandResponse(wasSuccessful);
      }

   protected abstract byte[] getCommand();
   }
