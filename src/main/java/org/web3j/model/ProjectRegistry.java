package org.web3j.model;

import io.reactivex.Flowable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.abi.datatypes.generated.Uint8;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple8;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/LFDT-web3j/web3j/tree/main/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.14.0.
 */
@SuppressWarnings("rawtypes")
public class ProjectRegistry extends Contract {
    public static final String BINARY = "";

    private static String librariesLinkedBinary;

    public static final String FUNC_ADDREVIEW = "addReview";

    public static final String FUNC_ADMIN = "admin";

    public static final String FUNC_APPROVEPROJECT = "approveProject";

    public static final String FUNC_AVERAGESCORE = "averageScore";

    public static final String FUNC_CREATEPROJECT = "createProject";

    public static final String FUNC_GETPROJECT = "getProject";

    public static final String FUNC_HASREVIEWED = "hasReviewed";

    public static final String FUNC_NEXTID = "nextId";

    public static final String FUNC_PROJECTS = "projects";

    public static final String FUNC_UPDATEPROJECT = "updateProject";

    public static final Event PROJECTAPPROVED_EVENT = new Event("ProjectApproved", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>(true) {}, new TypeReference<Address>(true) {}));
    ;

    public static final Event PROJECTCREATED_EVENT = new Event("ProjectCreated", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}));
    ;

    public static final Event PROJECTREVIEWED_EVENT = new Event("ProjectReviewed", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint8>() {}));
    ;

    public static final Event PROJECTUPDATED_EVENT = new Event("ProjectUpdated", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>(true) {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}));
    ;

    @Deprecated
    protected ProjectRegistry(String contractAddress, Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected ProjectRegistry(String contractAddress, Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected ProjectRegistry(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected ProjectRegistry(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> addReview(BigInteger _id, BigInteger _score) {
        final Function function = new Function(
                FUNC_ADDREVIEW, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_id), 
                new org.web3j.abi.datatypes.generated.Uint8(_score)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> admin() {
        final Function function = new Function(FUNC_ADMIN, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> approveProject(BigInteger _id) {
        final Function function = new Function(
                FUNC_APPROVEPROJECT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_id)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> averageScore(BigInteger _id) {
        final Function function = new Function(FUNC_AVERAGESCORE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_id)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> createProject(String _title, String _ipfsHash) {
        final Function function = new Function(
                FUNC_CREATEPROJECT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_title), 
                new org.web3j.abi.datatypes.Utf8String(_ipfsHash)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Tuple8<BigInteger, String, String, String, BigInteger, Boolean, BigInteger, BigInteger>> getProject(
            BigInteger _id) {
        final Function function = new Function(FUNC_GETPROJECT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_id)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Address>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}, new TypeReference<Bool>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
        return new RemoteFunctionCall<Tuple8<BigInteger, String, String, String, BigInteger, Boolean, BigInteger, BigInteger>>(function,
                new Callable<Tuple8<BigInteger, String, String, String, BigInteger, Boolean, BigInteger, BigInteger>>() {
                    @Override
                    public Tuple8<BigInteger, String, String, String, BigInteger, Boolean, BigInteger, BigInteger> call(
                            ) throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple8<BigInteger, String, String, String, BigInteger, Boolean, BigInteger, BigInteger>(
                                (BigInteger) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (String) results.get(2).getValue(), 
                                (String) results.get(3).getValue(), 
                                (BigInteger) results.get(4).getValue(), 
                                (Boolean) results.get(5).getValue(), 
                                (BigInteger) results.get(6).getValue(), 
                                (BigInteger) results.get(7).getValue());
                    }
                });
    }

    public RemoteFunctionCall<Boolean> hasReviewed(BigInteger param0, String param1) {
        final Function function = new Function(FUNC_HASREVIEWED, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0), 
                new org.web3j.abi.datatypes.Address(160, param1)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<BigInteger> nextId() {
        final Function function = new Function(FUNC_NEXTID, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<Tuple8<BigInteger, String, String, String, BigInteger, Boolean, BigInteger, BigInteger>> projects(
            BigInteger param0) {
        final Function function = new Function(FUNC_PROJECTS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Address>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}, new TypeReference<Bool>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
        return new RemoteFunctionCall<Tuple8<BigInteger, String, String, String, BigInteger, Boolean, BigInteger, BigInteger>>(function,
                new Callable<Tuple8<BigInteger, String, String, String, BigInteger, Boolean, BigInteger, BigInteger>>() {
                    @Override
                    public Tuple8<BigInteger, String, String, String, BigInteger, Boolean, BigInteger, BigInteger> call(
                            ) throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple8<BigInteger, String, String, String, BigInteger, Boolean, BigInteger, BigInteger>(
                                (BigInteger) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (String) results.get(2).getValue(), 
                                (String) results.get(3).getValue(), 
                                (BigInteger) results.get(4).getValue(), 
                                (Boolean) results.get(5).getValue(), 
                                (BigInteger) results.get(6).getValue(), 
                                (BigInteger) results.get(7).getValue());
                    }
                });
    }

    public RemoteFunctionCall<TransactionReceipt> updateProject(BigInteger _id, String _title,
            String _ipfsHash) {
        final Function function = new Function(
                FUNC_UPDATEPROJECT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_id), 
                new org.web3j.abi.datatypes.Utf8String(_title), 
                new org.web3j.abi.datatypes.Utf8String(_ipfsHash)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public static List<ProjectApprovedEventResponse> getProjectApprovedEvents(
            TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(PROJECTAPPROVED_EVENT, transactionReceipt);
        ArrayList<ProjectApprovedEventResponse> responses = new ArrayList<ProjectApprovedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ProjectApprovedEventResponse typedResponse = new ProjectApprovedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.id = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.admin = (String) eventValues.getIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static ProjectApprovedEventResponse getProjectApprovedEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(PROJECTAPPROVED_EVENT, log);
        ProjectApprovedEventResponse typedResponse = new ProjectApprovedEventResponse();
        typedResponse.log = log;
        typedResponse.id = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
        typedResponse.admin = (String) eventValues.getIndexedValues().get(1).getValue();
        return typedResponse;
    }

    public Flowable<ProjectApprovedEventResponse> projectApprovedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getProjectApprovedEventFromLog(log));
    }

    public Flowable<ProjectApprovedEventResponse> projectApprovedEventFlowable(
            DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(PROJECTAPPROVED_EVENT));
        return projectApprovedEventFlowable(filter);
    }

    public static List<ProjectCreatedEventResponse> getProjectCreatedEvents(
            TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(PROJECTCREATED_EVENT, transactionReceipt);
        ArrayList<ProjectCreatedEventResponse> responses = new ArrayList<ProjectCreatedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ProjectCreatedEventResponse typedResponse = new ProjectCreatedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.id = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.submitter = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.title = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.ipfsHash = (String) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static ProjectCreatedEventResponse getProjectCreatedEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(PROJECTCREATED_EVENT, log);
        ProjectCreatedEventResponse typedResponse = new ProjectCreatedEventResponse();
        typedResponse.log = log;
        typedResponse.id = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
        typedResponse.submitter = (String) eventValues.getIndexedValues().get(1).getValue();
        typedResponse.title = (String) eventValues.getNonIndexedValues().get(0).getValue();
        typedResponse.ipfsHash = (String) eventValues.getNonIndexedValues().get(1).getValue();
        return typedResponse;
    }

    public Flowable<ProjectCreatedEventResponse> projectCreatedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getProjectCreatedEventFromLog(log));
    }

    public Flowable<ProjectCreatedEventResponse> projectCreatedEventFlowable(
            DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(PROJECTCREATED_EVENT));
        return projectCreatedEventFlowable(filter);
    }

    public static List<ProjectReviewedEventResponse> getProjectReviewedEvents(
            TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(PROJECTREVIEWED_EVENT, transactionReceipt);
        ArrayList<ProjectReviewedEventResponse> responses = new ArrayList<ProjectReviewedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ProjectReviewedEventResponse typedResponse = new ProjectReviewedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.id = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.reviewer = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.score = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static ProjectReviewedEventResponse getProjectReviewedEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(PROJECTREVIEWED_EVENT, log);
        ProjectReviewedEventResponse typedResponse = new ProjectReviewedEventResponse();
        typedResponse.log = log;
        typedResponse.id = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
        typedResponse.reviewer = (String) eventValues.getIndexedValues().get(1).getValue();
        typedResponse.score = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
        return typedResponse;
    }

    public Flowable<ProjectReviewedEventResponse> projectReviewedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getProjectReviewedEventFromLog(log));
    }

    public Flowable<ProjectReviewedEventResponse> projectReviewedEventFlowable(
            DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(PROJECTREVIEWED_EVENT));
        return projectReviewedEventFlowable(filter);
    }

    public static List<ProjectUpdatedEventResponse> getProjectUpdatedEvents(
            TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(PROJECTUPDATED_EVENT, transactionReceipt);
        ArrayList<ProjectUpdatedEventResponse> responses = new ArrayList<ProjectUpdatedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ProjectUpdatedEventResponse typedResponse = new ProjectUpdatedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.id = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.title = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.ipfsHash = (String) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static ProjectUpdatedEventResponse getProjectUpdatedEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(PROJECTUPDATED_EVENT, log);
        ProjectUpdatedEventResponse typedResponse = new ProjectUpdatedEventResponse();
        typedResponse.log = log;
        typedResponse.id = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
        typedResponse.title = (String) eventValues.getNonIndexedValues().get(0).getValue();
        typedResponse.ipfsHash = (String) eventValues.getNonIndexedValues().get(1).getValue();
        return typedResponse;
    }

    public Flowable<ProjectUpdatedEventResponse> projectUpdatedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getProjectUpdatedEventFromLog(log));
    }

    public Flowable<ProjectUpdatedEventResponse> projectUpdatedEventFlowable(
            DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(PROJECTUPDATED_EVENT));
        return projectUpdatedEventFlowable(filter);
    }

    @Deprecated
    public static ProjectRegistry load(String contractAddress, Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        return new ProjectRegistry(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static ProjectRegistry load(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new ProjectRegistry(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static ProjectRegistry load(String contractAddress, Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        return new ProjectRegistry(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static ProjectRegistry load(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new ProjectRegistry(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<ProjectRegistry> deploy(Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider, String _admin) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _admin)));
        return deployRemoteCall(ProjectRegistry.class, web3j, credentials, contractGasProvider, getDeploymentBinary(), encodedConstructor);
    }

    public static RemoteCall<ProjectRegistry> deploy(Web3j web3j,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider,
            String _admin) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _admin)));
        return deployRemoteCall(ProjectRegistry.class, web3j, transactionManager, contractGasProvider, getDeploymentBinary(), encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<ProjectRegistry> deploy(Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit, String _admin) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _admin)));
        return deployRemoteCall(ProjectRegistry.class, web3j, credentials, gasPrice, gasLimit, getDeploymentBinary(), encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<ProjectRegistry> deploy(Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit,
            String _admin) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _admin)));
        return deployRemoteCall(ProjectRegistry.class, web3j, transactionManager, gasPrice, gasLimit, getDeploymentBinary(), encodedConstructor);
    }

    public static void linkLibraries(List<Contract.LinkReference> references) {
        librariesLinkedBinary = linkBinaryWithReferences(BINARY, references);
    }

    private static String getDeploymentBinary() {
        if (librariesLinkedBinary != null) {
            return librariesLinkedBinary;
        } else {
            return BINARY;
        }
    }

    public static class ProjectApprovedEventResponse extends BaseEventResponse {
        public BigInteger id;

        public String admin;
    }

    public static class ProjectCreatedEventResponse extends BaseEventResponse {
        public BigInteger id;

        public String submitter;

        public String title;

        public String ipfsHash;
    }

    public static class ProjectReviewedEventResponse extends BaseEventResponse {
        public BigInteger id;

        public String reviewer;

        public BigInteger score;
    }

    public static class ProjectUpdatedEventResponse extends BaseEventResponse {
        public BigInteger id;

        public String title;

        public String ipfsHash;
    }
}
