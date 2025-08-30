package com.rdquispe.backend.infraestructure.util;

public class Constants {

    private Constants() {}

    public static final String XML_YUNO = """
            <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
            <Document xmlns='urn:iso:std:iso:20022:tech:xsd:pain.002.001.03'
            	xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance'>
            	<CstmrPmtStsRpt>
            		<GrpHdr>
            			<MsgId>RESP2023-11-09T15:03:07:348</MsgId>
            			<CreDtTm>2023-11-09T15:03:07</CreDtTm>
            			<InitgPty>
            				<Nm>YUNO</Nm>
            			</InitgPty>
            		</GrpHdr>
            		<OrgnlGrpInfAndSts>
            			<OrgnlMsgId>mco:withdraw:yuno:1681402500000</OrgnlMsgId>
            			<OrgnlMsgNmId>pain.001.001.03</OrgnlMsgNmId>
            			<OrgnlCreDtTm>2023-04-13T12:20:11</OrgnlCreDtTm>
            			<OrgnlNbOfTxs>1</OrgnlNbOfTxs>
            			<OrgnlCtrlSum>1356.92</OrgnlCtrlSum>
            			<GrpSts>ACTC</GrpSts>
            			<NbOfTxsPerSts>
            				<DtldNbOfTxs>1</DtldNbOfTxs>
            				<DtldSts>ACTC</DtldSts>
            				<DtldCtrlSum>1356.92</DtldCtrlSum>
            			</NbOfTxsPerSts>
            		</OrgnlGrpInfAndSts>
            		<OrgnlPmtInfAndSts>
            			<OrgnlPmtInfId>mco:withdraw:yuno:1681402500000</OrgnlPmtInfId>
            			<PmtInfSts>ACTC</PmtInfSts>
            			<NbOfTxsPerSts>
            				<DtldNbOfTxs>1</DtldNbOfTxs>
            				<DtldSts>ACTC</DtldSts>
            				<DtldCtrlSum>1356.92</DtldCtrlSum>
            			</NbOfTxsPerSts>
            			<TxInfAndSts>
            				<StsId>RESP2023-11-09T15:03:07:348/0000001</StsId>
            				<OrgnlInstrId>56864864552</OrgnlInstrId>
            				<OrgnlEndToEndId>56864864</OrgnlEndToEndId>
            				<TxSts>ACTC</TxSts>
            				<OrgnlTxRef>
            					<Amt>
            						<InstdAmt Ccy="COP">1356.92</InstdAmt>
            					</Amt>
            					<ReqdExctnDt>2023-04-14</ReqdExctnDt>
            					<Dbtr>
            						<Nm>RODRIGO QUISPE</Nm>
            					</Dbtr>
            					<DbtrAcct>
            						<Id>
            							<Othr>
            								<Id>01112300010007815470</Id>
            							</Othr>
            						</Id>
            					</DbtrAcct>
            					<DbtrAgt>
            						<FinInstnId>
            							<BIC>BCONPEPLXXX</BIC>
            						</FinInstnId>
            					</DbtrAgt>
            					<Cdtr>
            						<Nm>COMPANY MDE S.A</Nm>
            					</Cdtr>
            				</OrgnlTxRef>
            			</TxInfAndSts>
            		</OrgnlPmtInfAndSts>
            	</CstmrPmtStsRpt>
            </Document>
            """;
}
